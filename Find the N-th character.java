public class Solution {
    public char nthCharacter(String s, int r, int n) {
        int len = s.length();
        for (int i = 0; i < r; i++) {
            StringBuilder temp = new StringBuilder(s);
            for (int j = 0; j < len; j++) {
                if (temp.charAt(j / 2) == '0') {
                    s = s.substring(0, j) + (char) ('0' + (j % 2)) + s.substring(j + 1);
                } else {
                    s = s.substring(0, j) + (char) ('1' - (j % 2)) + s.substring(j + 1);
                }
            }
        }
        return s.charAt(n);
    }
}
