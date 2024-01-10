import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longSubarrWthSumDivByK(int[] arr, int n, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int out = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int rem = sum % k;

            if (rem < 0)
                rem += k;

            if (mp.containsKey(rem))
                out = Math.max(out, i - mp.get(rem));
            else
                mp.put(rem, i);
        }

        return out;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {2, 7, 6, 1, 4, 5};
        int n = arr.length;
        int k = 3;

        Solution solution = new Solution();
        int result = solution.longSubarrWthSumDivByK(arr, n, k);

        System.out.println("Length of the longest subarray with sum divisible by " + k + ": " + result);
    }
}
