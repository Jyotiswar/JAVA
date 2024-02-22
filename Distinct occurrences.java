import java.util.Arrays;

public class Solution {
    int mod = 1000000007;

    int solve(int i, int j, int n, int m, String s, String t, int[][] dp) {
        if (j == m)
            return 1;
        if (i == n)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ntake = solve(i + 1, j, n, m, s, t, dp);
        int take = 0;
        if (s.charAt(i) == t.charAt(j))
            take = solve(i + 1, j + 1, n, m, s, t, dp);

        return dp[i][j] = (take + ntake) % mod;
    }

    int subsequenceCount(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, n, m, s, t, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabc";
        String t = "abc";
        System.out.println(solution.subsequenceCount(s, t)); // Output: 7
    }
}
