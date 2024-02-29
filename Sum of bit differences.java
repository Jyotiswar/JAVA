public class Solution {
    public long sumBitDifferences(int[] arr, int n) {
        long out = 0;
        for (int i = 0; i < 32; ++i) {
            long one = 0;
            for (int j = 0; j < n; ++j) {
                if ((arr[j] & (1 << i)) != 0) {
                    ++one;
                }
            }
            long zero = n - one;
            out += 2 * one * zero;
        }
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 5};
        int n = arr.length;
        long result = solution.sumBitDifferences(arr, n);
        System.out.println(result);
    }
}
