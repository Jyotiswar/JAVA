import java.util.Arrays;

class Solution {
    public int[] maximumWeight(int n, int[][] edges, int q, int[] queries) {
        int[] par = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(b[2], a[2]));
        int[][] indexedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            indexedQueries[i] = new int[]{i, queries[i]};
        }
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[1], b[1]));

        int[] res = new int[q];
        int cur = 0;
        int edgeIdx = 0;
        for (int[] indexedQuery : indexedQueries) {
            int idx = indexedQuery[0];
            int x = indexedQuery[1];
            while (edgeIdx < edges.length && edges[edgeIdx][2] <= x) {
                int[] edge = edges[edgeIdx];
                int u = find(edge[0] - 1, par);
                int v = find(edge[1] - 1, par);
                if (u != v) {
                    par[v] = u;
                    cur += rank[u] * rank[v];
                    rank[u] += rank[v];
                }
                edgeIdx++;
            }
            res[idx] = cur;
        }

        return res;
    }

    private int find(int n1, int[] par) {
        while (par[n1] != n1) {
            par[n1] = par[par[n1]];
            n1 = par[n1];
        }
        return par[n1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{1, 2, 3}, {2, 3, 1}, {2, 4, 9}, {3, 6, 7}, {3, 5, 8}, {5, 7, 4}};
        int q = 3;
        int[] queries = {1, 3, 5};

        Solution solution = new Solution();
        int[] result = solution.maximumWeight(n, edges, q, queries);
        System.out.println("Maximum weights: " + Arrays.toString(result));
    }
}
