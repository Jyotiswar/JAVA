public class Solution {
    public void swapElements(int[] arr, int n) {
        for (int i = 0; i < n - 2; ++i) {
            arr[i] = arr[i] ^ arr[i + 2];
            arr[i + 2] = arr[i] ^ arr[i + 2];
            arr[i] = arr[i] ^ arr[i + 2];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5}; // Example array
        int n = arr.length;
        solution.swapElements(arr, n);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
