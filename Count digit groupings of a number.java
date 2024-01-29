import java.util.Arrays;

public class Solution {

    public int solve(int cp, int cs, int sz, String s, int[][] dp) {
        if (cp == sz)
            return 1;

        if (dp[cp][cs] != -1)
            return dp[cp][cs];

        int sm = 0, cnt = 0;

        for (int i = cp; i < sz; i++) {
            sm += s.charAt(i) - '0';
            if (sm >= cs)
                cnt += solve(i + 1, sm, sz, s, dp);
        }

        return dp[cp][cs] = cnt;
    }

    public int totalCount(String str) {
        int sm = 0;
        for (char c : str.toCharArray())
            sm += c - '0';

        int[][] dp = new int[str.length() + 1][sm + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, str.length(), str, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String inputString = "12345";  // Replace with your input string
        int result = solution.totalCount(inputString);
        System.out.println("Total Count: " + result);
    }
}
