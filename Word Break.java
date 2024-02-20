import java.util.*;

class Solution {
    public int wordBreak(int n, String s, List<String> dictionary) {
        int nn = s.length();
        int[] dp = new int[nn + 1];
        dp[nn] = 1;
        for (int i = nn - 1; i >= 0; i--) {
            for (String w : dictionary) {
                if (i + w.length() <= nn && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i] != 0) {
                    break;
                }
            }
        }
        return dp[0];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "leetcode";
        List<String> dictionary = Arrays.asList("leet", "code");
        System.out.println(sol.wordBreak(s.length(), s, dictionary)); // Output: 1
    }
}
