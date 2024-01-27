public class Solution {
    class Pair {
        int first;
        String second;

        Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public String matrixChainOrder(int[] p, int n) {
        Pair[][] dp = new Pair[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                if (gap == 1) {
                    StringBuilder res = new StringBuilder("0");
                    res.setCharAt(0, (char)('A' + i));
                    dp[i][j] = new Pair(0, res.toString());
                } else {
                    dp[i][j] = new Pair(Integer.MAX_VALUE, "-1");
                    for (int k = i + 1; k <= j - 1; k++) {
                        int cost = p[i] * p[k] * p[j] + dp[i][k].first + dp[k][j].first;
                        if (dp[i][j].first > cost) {
                            dp[i][j].first = cost;
                            dp[i][j].second = "(" + dp[i][k].second + dp[k][j].second + ")";
                        }
                    }
                }
            }
        }

        return dp[0][n - 1].second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p = { 1, 2, 3, 4 };
        int n = p.length;
        String result = solution.matrixChainOrder(p, n);
        System.out.println(result);
    }
}
