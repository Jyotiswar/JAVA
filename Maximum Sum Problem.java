import java.util.Arrays;

public class Solution {
    public int maxSum(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i / 2] + dp[i / 3] + dp[i / 4];
            dp[i] = Math.max(dp[i], i);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10; // Example value of n
        System.out.println(solution.maxSum(n)); // Output: 20
    }
}
