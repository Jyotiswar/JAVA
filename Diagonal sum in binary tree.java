import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public List<Integer> diagonalSum(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int cur, List<Integer> ans) {
        if (node == null)
            return;
        if (cur == ans.size())
            ans.add(node.val);
        else
            ans.set(cur, ans.get(cur) + node.val);
        dfs(node.left, cur + 1, ans);
        dfs(node.right, cur, ans);
    }
}
