import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void solve(int i, int bits, int n, int m, List<Pair<Integer, Integer>> edges, int[] out) {
        if (i > n) {
            for (int j = 0; j < m; j++) {
                if ((bits & (1 << (edges.get(j).getKey() - 1))) == 0 && (bits & (1 << (edges.get(j).getValue() - 1))) == 0) {
                    return;
                }
            }
            out[0] = Math.min(out[0], Integer.bitCount(bits));
            return;
        }
        solve(i + 1, bits, n, m, edges, out);
        solve(i + 1, bits | (1 << (i - 1)), n, m, edges, out);
    }

    public int vertexCover(int n, List<Pair<Integer, Integer>> edges) {
        int[] out = {Integer.MAX_VALUE};
        int m = edges.size();
        solve(1, 0, n, m, edges, out);
        return out[0];
    }

    public static void main(String[] args) {
        // You can create a sample graph and test the functionality here
        // For example:
        // int n = 3;
        // List<Pair<Integer, Integer>> edges = new ArrayList<>();
        // edges.add(new Pair<>(1, 2));
        // edges.add(new Pair<>(2, 3));
        // Solution solution = new Solution();
        // int result = solution.vertexCover(n, edges);
        // System.out.println("Result: " + result);
    }
}
