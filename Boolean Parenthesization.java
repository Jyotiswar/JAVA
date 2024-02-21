import java.util.Scanner;

class Solution {
    public int countWays(int n, String s) {
        int[][][] dp = new int[n][n][2];
        final int mod = 1003;

        for (int i = n - 1; i > -1; i -= 2) {
            for (int j = i; j < n; j += 2) {
                if (i == j) {
                    dp[i][j][1] = s.charAt(i) == 'T' ? 1 : 0;
                    dp[i][j][0] = s.charAt(i) == 'F' ? 1 : 0;
                } else {
                    dp[i][j][1] = dp[i][j][0] = 0;

                    for (int k = i; k < j; k += 2) {
                        int f1 = dp[i][k][1], f0 = dp[i][k][0], s1 = dp[k + 2][j][1], s0 = dp[k + 2][j][0];

                        if (s.charAt(k + 1) == '&') {
                            dp[i][j][1] = (dp[i][j][1] + (f1 * s1) % mod) % mod;
                            dp[i][j][0] = (dp[i][j][0] + (f1 * s0) % mod + (f0 * s1) % mod + (f0 * s0) % mod) % mod;
                        } else if (s.charAt(k + 1) == '|') {
                            dp[i][j][1] = (dp[i][j][1] + (f1 * s0) % mod + (f0 * s1) % mod + (f1 * s1) % mod) % mod;
                            dp[i][j][0] = (dp[i][j][0] + (f0 * s0) % mod) % mod;
                        } else {
                            dp[i][j][1] = (dp[i][j][1] + (f1 * s0) % mod + (f0 * s1) % mod) % mod;
                            dp[i][j][0] = (dp[i][j][0] + (f1 * s1) % mod + (f0 * s0) % mod) % mod;
                        }
                    }
                }
            }
        }

        return dp[0][n - 1][1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the string:");
        int n = scanner.nextInt();
        System.out.println("Enter the boolean expression:");
        String s = scanner.next();
        Solution solution = new Solution();
        int result = solution.countWays(n, s);
        System.out.println("Number of ways to parenthesize the expression: " + result);
        scanner.close();
    }
}
