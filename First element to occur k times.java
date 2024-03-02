import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstElementKTime(int n, int k, int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            if (map.get(a[i]) == k)
                return a[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 2, 3, 4, 2}; // Example array
        int n = arr.length;
        int k = 3; // Example value of k
        int result = solution.firstElementKTime(n, k, arr);
        System.out.println(result);
    }
}
