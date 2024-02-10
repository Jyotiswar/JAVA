import java.util.function.Function;

public class Solution {
    
    public long numberOfPath(int n, int k, int[][] arr) {
        int[] dr = {1, 0};
        int[] dc = {0, 1};
                 // D, R
        
        // Validity check function
        Function<Integer, Integer, Boolean> valid = (x, y) -> {
            return x >= 0 && x < n && y >= 0 && y < n;
        };
        
        long[][][] dp = new long[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p <= k; p++) {
                    dp[i][j][p] = -1;
                }
            }
        }
        
        // Helper function for recursive traversal
        Function<Integer, Integer, Integer, Long> helper = (r, c, sum) -> {
            if (r == n - 1 && c == n - 1) {
                return sum == arr[r][c] ? 1 : 0;
            }
            
            if (dp[r][c][sum] != -1) {
                return dp[r][c][sum];
            }
            
            dp[r][c][sum] = 0;
                
            if (arr[r][c] <= sum) {
                for (int dir = 0; dir < 2; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    
                    if (valid.apply(nr, nc)) {
                        dp[r][c][sum] += helper.apply(nr, nc, sum - arr[r][c]);
                    }
                }            
            }
            
            return dp[r][c][sum];
        };
        
        return helper.apply(0, 0, k);
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();

        // Example input
        int n = 3;
        int k = 12;
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        long result = solution.numberOfPath(n, k, arr);
        System.out.println("Number of paths with sum " + k + " in the matrix: " + result);
    }
}
