public class Solution {
    public static int[] game_with_number(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i] | arr[i + 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example array
        int n = arr.length;
        
        int[] result = game_with_number(arr, n);
        
        System.out.println("Modified Array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
