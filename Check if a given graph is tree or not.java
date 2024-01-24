import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void dfs(int s, List<Integer>[] graph, boolean[] vis) {
        vis[s] = true;
        for (int i : graph[s]) {
            if (!vis[i]) {
                dfs(i, graph, vis);
            }
        }
    }

    public int isTree(int n, int m, int[][] adj) {
        if ((n - m) != 1) {
            return 0;
        }

        boolean[] vis = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] i : adj) {
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }

        dfs(0, graph, vis);

        for (boolean i : vis) {
            if (!i) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        // You can create a sample adjacency list and test the functionality here
        // For example:
        // int n = 5;
        // int m = 4;
        // int[][] adj = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        // Solution solution = new Solution();
        // int result = solution.isTree(n, m, adj);
        // System.out.println("Result: " + result);
    }
}
