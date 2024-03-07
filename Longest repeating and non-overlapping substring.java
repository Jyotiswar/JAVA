public class Solution {
    public static String longestSubstring(String s, int n) {
        int maxLen = 0;
        String out = "-1";
        
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                String str = s.substring(i, j + 1);
                if (str.length() > maxLen && s.indexOf(str, j + 1) != -1) {
                    maxLen = str.length();
                    out = str;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int n = s.length();
        String result = longestSubstring(s, n);
        System.out.println(result);
    }
}
