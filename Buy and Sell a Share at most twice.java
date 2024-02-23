import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] price) {
        int n = price.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i > -1; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = 0;

                    if (j == 1) {
                        dp[i][j][k] = Math.max(price[i] + dp[i + 1][0][k - 1], dp[i + 1][1][k]);
                    } else {
                        dp[i][j][k] = Math.max(-price[i] + dp[i + 1][1][k], dp[i + 1][0][k]);
                    }
                }
            }
        }

        return dp[0][0][2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices)); // Output: 7
    }
}
