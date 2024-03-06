import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> search(String pattern, String text) {
        List<Integer> out = new ArrayList<>();
        int mod = 10;
        int h = pattern.length();
        int n = text.length();
        int hashp = 0;
        int hasht = 0;
        int p = 1;

        for (int i = 0; i < h - 1; ++i)
            p = (p * 26) % mod;

        for (int i = 0; i < h; ++i) {
            hashp = ((hashp * 26) + pattern.charAt(i) - 'a') % mod;
            hasht = ((hasht * 26) + text.charAt(i) - 'a') % mod;
        }

        for (int i = 0; i <= n - h; ++i) {
            if (hashp == hasht) {
                int j;
                for (j = 0; j < h; ++j)
                    if (pattern.charAt(j) != text.charAt(i + j))
                        break;

                if (j == h)
                    out.add(i + 1);
            }
            if (i < n - h) {
                hasht = (26 * (hasht - (text.charAt(i) - 'a') * p) + (text.charAt(i + h) - 'a')) % mod;
                if (hasht < 0)
                    hasht += mod;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String pattern = "abc";
        String text = "abcbabc";
        List<Integer> result = solution.search(pattern, text);
        System.out.println(result);
    }
}
