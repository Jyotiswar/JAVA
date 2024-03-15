import java.util.*;

public class Solution {
    public int largestSubsquare(int n, char[][] a) {
        int[][] col = new int[n][n];
        int[][] row = new int[n][n];
        
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = n - 1; j >= 0; --j) {
                sum = (a[i][j] == 'O') ? 0 : sum + 1;
                col[i][j] = sum;
            }
        }
        
        for (int j = 0; j < n; ++j) {
            int sum = 0;
            for (int i = n - 1; i >= 0; --i) {
                sum = (a[i][j] == 'O') ? 0 : sum + 1;
                row[i][j] = sum;
            }
        }
        
        int out = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sq = Math.min(col[i][j], row[i][j]);
                while (sq > out) {
                    if (col[i + sq - 1][j] >= sq && row[i][j + sq - 1] >= sq)
                        out = sq;
                    
                    --sq;
                }
            }
        }
        return out;
    }
}