import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Solution {
    public boolean check(Node root) {
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int firstLeaf = -1;

        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int lvl = pair.getValue();

            if (node.left == null && node.right == null) {
                if (firstLeaf == -1)
                    firstLeaf = lvl;
                else if (firstLeaf != lvl)
                    return false;
            }
            lvl++;
            if (node.left != null)
                q.add(new Pair<>(node.left, lvl));
            if (node.right != null)
                q.add(new Pair<>(node.right, lvl));
        }
        return true;
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

        boolean result = solution.check(root);
        System.out.println("All leaf nodes are at the same level: " + result);
    }

    // Utility class for Pair
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
