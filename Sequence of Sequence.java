public class Solution {
    public int solve(int n, int m) {
        if (m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        int t = solve(n - 1, m / 2);
        int nt = solve(n, m - 1);

        return t + nt;
    }

    public int numberSequence(int m, int n) {
        return solve(n, m);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 5; // Set your value for m
        int n = 3; // Set your value for n

        int result = solution.numberSequence(m, n);
        System.out.println("Result: " + result);
    }
}
