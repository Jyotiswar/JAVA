import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    // Function to store the zigzag order traversal of tree in a list.
    List<Integer> ans = new ArrayList<>();

    public List<Integer> zigZagTraversal(TreeNode root) {
        if (root == null)
            return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean left = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> vec = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                int ind = left ? i : (size - 1 - i);
                vec.add(ind, temp.data);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            left = !left;
            ans.addAll(vec);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<Integer> result = solution.zigZagTraversal(root);
        System.out.println(result);
    }
}
