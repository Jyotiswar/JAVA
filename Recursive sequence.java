public class Solution {
    public long sequence(int n) {
        long mod = 1000000007;
        long out = 0;
        long c = 1;

        for (int i = 1; i <= n; ++i) {
            long temp = 1;
            for (int j = 0; j < i ; ++j) {
                temp *= c++;
                temp %= mod;
            }
            out = (out + temp) % mod;
        }
        return out;
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();

        // Example input
        int n = 5;
        long result = solution.sequence(n);
        System.out.println("Sequence result: " + result);
    }
}
