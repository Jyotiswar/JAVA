import javafx.util.Pair;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    Pair<Integer, Integer> dfs(Node node) {
        if (node == null)
            return new Pair<>(0, 0);

        Pair<Integer, Integer> left = dfs(node.left);
        Pair<Integer, Integer> right = dfs(node.right);

        Pair<Integer, Integer> ans;
        if (left.getValue() > right.getValue())
            ans = left;
        else if (right.getValue() > left.getValue())
            ans = right;
        else {
            int maxSum = Math.max(left.getKey(), right.getKey());
            ans = new Pair<>(maxSum, left.getValue());
        }

        ans = new Pair<>(ans.getKey() + node.data, ans.getValue() + 1);
        return ans;
    }

    int sumOfLongRootToLeafPath(Node root) {
        return dfs(root).getKey();
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);

        Solution solution = new Solution();
        System.out.println("Sum of longest root-to-leaf path: " + solution.sumOfLongRootToLeafPath(root));
    }
}
