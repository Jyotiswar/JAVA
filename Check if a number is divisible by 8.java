public class Solution {
    public int DivisibleByEight(String s) {
        int n = Integer.parseInt(s.substring(Math.max(s.length() - 3, 0)));
        
        return n % 8 != 0 ? -1 : 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "123456789"; // Example string
        int result = solution.DivisibleByEight(s);
        System.out.println(result);
    }
}
