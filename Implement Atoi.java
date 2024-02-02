public class Solution {

    public int atoi(String s) {
        int n = 0;
        boolean isNegative = false;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (i == 0 && currentChar == '-')
                isNegative = true;
            else if (currentChar >= '0' && currentChar <= '9')
                n = n * 10 + (currentChar - '0');
            else
                return -1; // Invalid input, not a number
        }

        return (isNegative) ? -n : n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String testString = "-12345"; // Replace with your test string
        int result = solution.atoi(testString);
        System.out.println("Converted Integer: " + result);
    }
}
