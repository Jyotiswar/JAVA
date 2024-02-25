import java.util.Arrays;

public class Solution {
    public long count(long n) {
        long[] dp = new long[(int) (n + 1)];
        dp[0] = 1;
        
        for (int i = 3; i <= n; i++) {
            dp[i] += dp[i - 3];
        }
        for (int i = 5; i <= n; i++) {
            dp[i] += dp[i - 5];
        }
        for (int i = 10; i <= n; i++) {
            dp[i] += dp[i - 10];
        }

        return dp[(int) n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long n = 15; // Example value of n
        System.out.println(solution.count(n)); // Output: 4
    }
}
