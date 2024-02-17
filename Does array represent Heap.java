public class Solution {
    public boolean isMaxHeap(int[] arr, int n) {
        int st = n / 2;
        for (int i = st; i >= 0; --i) {
            if ((i * 2 + 1 < n && arr[i] < arr[i * 2 + 1]) || (i * 2 + 2 < n && arr[i] < arr[i * 2 + 2])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {10, 8, 7, 6, 5, 4, 3, 2, 1}; // Max heap
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};    // Not a max heap

        System.out.println("Is arr1 a max heap? " + solution.isMaxHeap(arr1, arr1.length));
        System.out.println("Is arr2 a max heap? " + solution.isMaxHeap(arr2, arr2.length));
    }
}
