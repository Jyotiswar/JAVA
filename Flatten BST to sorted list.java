import java.util.function.Function;
import javafx.util.Pair;

public class Solution {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public Node flattenBST(Node root) {
        Function<Node, Pair<Node, Node>> dfs = node -> {
            if (node == null)
                return new Pair<>(null, null);

            Pair<Node, Node> left = dfs.apply(node.left);
            Pair<Node, Node> right = dfs.apply(node.right);

            node.left = left.getKey();
            node.right = right.getKey();

            Node min = left.getKey() != null ? left.getKey() : node;
            Node max = right.getValue() != null ? right.getValue() : node;

            if (left.getKey() != null)
                max.right = node;

            node.left = null;
            return new Pair<>(min, max);
        };

        return dfs.apply(root).getKey();
    }
}
