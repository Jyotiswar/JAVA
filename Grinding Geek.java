import java.util.Arrays;

public class Solution {
    public int solve(int i, int total, int[] cost, int[][] dp) {
        if (i == cost.length)
            return 0;

        if (dp[i][total] != -1)
            return dp[i][total];

        int t = 0, nt = 0;
        if (total >= cost[i]) {
            // for taking case
            int ac = cost[i] - (int) Math.floor(0.9 * cost[i]); // actual cost that the user bears
            t = 1 + solve(i + 1, total - ac, cost, dp);
        }
        nt = solve(i + 1, total, cost, dp); // for non-taking case

        return dp[i][total] = Math.max(t, nt);
    }

    public int maxCourses(int n, int total, int[] cost) {
        int[][] dp = new int[n][total + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, total, cost, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        int n = 3;
        int total = 10;
        int[] cost = {3, 5, 7};

        int result = solution.maxCourses(n, total, cost);
        System.out.println("Maximum courses: " + result);
    }
}
