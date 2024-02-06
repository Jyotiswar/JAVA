import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Solution {
    int cnt;

    private void dfs(Node node, int k, int lvl, Map<Integer, Boolean> mp) {
        if (node == null)
            return;

        mp.put(lvl, false);

        if (node.left == null && node.right == null) {
            if (lvl - k >= 0 && !mp.get(lvl - k)) {
                mp.put(lvl - k, true);
                cnt++;
            }
        }

        lvl++;
        dfs(node.left, k, lvl, mp);
        dfs(node.right, k, lvl, mp);
    }

    public int printKDistantfromLeaf(Node root, int k) {
        cnt = 0;
        Map<Integer, Boolean> mp = new HashMap<>();
        dfs(root, k, 0, mp);
        return cnt;
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();

        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        int result = solution.printKDistantfromLeaf(root, k);
        System.out.println("Number of nodes at distance " + k + " from leaf nodes: " + result);
    }
}
