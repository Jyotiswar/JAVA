import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> uniquePerms(List<Integer> arr) {
        List<List<Integer>> out = new ArrayList<>();
        int n = arr.size();
        
        // Sorting the input list
        arr.sort(Integer::compareTo);
        
        do {
            // Creating a new ArrayList to store a copy of the current permutation
            List<Integer> currentPermutation = new ArrayList<>(arr);
            out.add(currentPermutation);
        } while (nextPermutation(arr));

        return out;
    }

    private boolean nextPermutation(List<Integer> arr) {
        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = arr.size() - 1;
        while (arr.get(j) <= arr.get(i)) {
            j--;
        }

        swap(arr, i, j);
        reverse(arr, i + 1);

        return true;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private void reverse(List<Integer> arr, int start) {
        int i = start;
        int j = arr.size() - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> arr = Arrays.asList(3, 1, 2); // Set your input array

        List<List<Integer>> result = solution.uniquePerms(arr);
        System.out.println("Unique Permutations: " + result);
    }
}
