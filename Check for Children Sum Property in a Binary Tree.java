class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Solution {
    public int isSumProperty(Node root) {
        if (root == null)
            return 1;
        if (root.left == null && root.right == null)
            return 1;

        int leftSum = 0, rightSum = 0;
        if (root.left != null)
            leftSum = root.left.data;
        if (root.right != null)
            rightSum = root.right.data;

        if (root.data == leftSum + rightSum && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();

        // Constructing the binary tree
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);

        int result = solution.isSumProperty(root);
        System.out.println("Is the sum property satisfied in the binary tree? " + (result == 1 ? "Yes" : "No"));
    }
}
