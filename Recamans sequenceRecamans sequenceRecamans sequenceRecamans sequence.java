import java.util.*;

public class Solution {
    public int[] recamanSequence(int n) {
        int[] a = new int[n + 1];
        Set<Integer> st = new HashSet<>();
        a[0] = 0;
        st.add(0);

        for (int i = 1; i <= n; ++i) {
            if (a[i - 1] - i > 0 && !st.contains(a[i - 1] - i))
                a[i] = a[i - 1] - i;
            else
                a[i] = a[i - 1] + i;
            st.add(a[i]);
        }

        return a;
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();

        // Example input
        int n = 10;
        int[] result = solution.recamanSequence(n);
        System.out.println("Recaman Sequence up to " + n + " elements: " + Arrays.toString(result));
    }
}
