import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    private int timer = 0;
    private List<List<Integer>> ans = new ArrayList<>();
    private int[] vis, dis, low;

    public List<List<Integer>> criticalConnections(int v, List<Integer>[] adj) {
        vis = new int[v];
        dis = new int[v];
        low = new int[v];
        Arrays.fill(vis, 0);
        Arrays.fill(dis, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < v; i++) {
            if (vis[i] == 0)
                dfs(i, -1, adj);
        }

        Collections.sort(ans, (a, b) -> {
            if (a.get(0) == b.get(0))
                return a.get(1) - b.get(1);
            return a.get(0) - b.get(0);
        });

        return ans;
    }

    private void dfs(int node, int parent, List<Integer>[] adj) {
        ++timer;
        vis[node] = 1;
        dis[node] = low[node] = timer;

        for (int it : adj[node]) {
            if (it == parent)
                continue;
            else if (vis[it] == 0)
                dfs(it, node, adj);

            low[node] = Math.min(low[node], low[it]);
            if (low[it] > dis[node]) {
                List<Integer> edge = new ArrayList<>();
                edge.add(Math.min(it, node));
                edge.add(Math.max(it, node));
                ans.add(edge);
            }
        }
    }
}
