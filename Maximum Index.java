public class Solution {
    // Function to find the maximum index difference.
    public int maxIndexDiff(int[] a, int n) {
        if (n == 1)
            return 0;
        int ans = -1;
        int[] lmin = new int[n];
        int[] rmax = new int[n];
        lmin[0] = a[0];
        for (int i = 1; i < n; i++) {
            lmin[i] = Math.min(lmin[i - 1], a[i]);
        }
        rmax[n - 1] = a[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rmax[j] = Math.max(rmax[j + 1], a[j]);
        }
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (lmin[i] <= rmax[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {34, 8, 10, 3, 2, 80, 30, 33, 1}; // Example array
        int n = a.length;
        int result = solution.maxIndexDiff(a, n);
        System.out.println(result);
    }
}
