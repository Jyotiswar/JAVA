public class Solution {
    public int peakElement(int[] arr, int n) {
        int left = 0, right = n - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 1}; // Example array
        int n = arr.length;
        int result = solution.peakElement(arr, n);
        System.out.println(result);
    }
}
