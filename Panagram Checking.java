import java.util.Arrays;

public class Solution {

    // Function to check if a string is Pangram or not.
    public boolean checkPangram(String s) {
        int[] f = new int[26];

        for (char i : s.toCharArray()) {
            char cur = Character.toLowerCase(i);

            if (cur >= 'a' && cur <= 'z') {
                f[cur - 'a'] = 1;
            }
        }

        return Arrays.stream(f).sum() == 26;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String testString = "The quick brown fox jumps over the lazy dog"; // Replace with your test string
        boolean isPangram = solution.checkPangram(testString);
        System.out.println("Is Pangram: " + isPangram);
    }
}
