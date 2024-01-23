import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int n, int m, int[][] pre) {
        List<Integer>[] graph = new ArrayList[n];
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] i : pre) {
            degree[i[0]]++;
            graph[i[1]].add(i[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int front = q.poll();

            ans.add(front);
            for (int i : graph[front]) {
                degree[i]--;
                if (degree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        for (int i : degree) {
            if (i >= 1) {
                return new int[]{};
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // You can create a sample graph and test the functionality here
        // For example:
        // int n = 4;
        // int m = 2;
        // int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        // Solution solution = new Solution();
        // int[] result = solution.findOrder(n, m, pre);
        // System.out.println("Result: " + Arrays.toString(result));
    }
}
