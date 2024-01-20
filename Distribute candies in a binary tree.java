class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class Solution {
    public int[] solve(TreeNode root, int[] moves) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left, moves);
        int[] right = solve(root.right, moves);
        moves[0] += Math.abs(left[0]) + Math.abs(left[1]) + Math.abs(right[0]) + Math.abs(right[1]);

        return new int[]{root.key - 1 + left[0] + right[0], root.key - 1 + left[1] + right[1]};
    }

    public int distributeCandy(TreeNode root) {
        int[] moves = {0};
        solve(root, moves);
        return moves[0];
    }

    public static void main(String[] args) {
        // You can create a sample tree and test the functionality here
        // For example:
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(4);
        // Solution solution = new Solution();
        // int result = solution.distributeCandy(root);
        // System.out.println("Result: " + result);
    }
}
