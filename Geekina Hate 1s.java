import java.util.Arrays;

public class Solution {

    public long findNthNumber(long n, long k) {

        long[][] dp = new long[63][];
        for (int i = 0; i < 63; i++) {
            dp[i] = new long[(int) (k + 1)];
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < 63; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int x = 0; x <= Math.min(i + 1, j); x++) {
                    dp[i][j] += ncr(i + 1, x);
                }
            }
        }

        long pos = 0;

        for (int i = 0; i < 63; i++) {
            if (dp[i][(int) k] >= n) {
                pos = i;
                break;
            }
        }

        long ans = 0;
        while (pos > -1 && n > 0) {
            if (pos + 1 <= k) {
                ans += n - 1;
                break;
            }

            if (pos > 0 && dp[(int) (pos - 1)][(int) k] < n) {
                ans |= (1L << pos);
                n -= dp[(int) (pos - 1)][(int) k];
                k = Math.max(k - 1, 0L);
            }

            --pos;
        }

        return ans;
    }

    private long ncr(long n, long r) {
        long ans = 1;

        for (long i = n; i > Math.max(r, n - r); i--)
            ans *= i;

        long den = 1;

        for (long i = 1; i <= Math.min(r, n - r); i++)
            den *= i;

        ans /= den;

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long n = 12;
        long k = 6;
        long result = solution.findNthNumber(n, k);
        System.out.println(result);
    }
}
