import java.util.ArrayList;
import java.util.List;

class Node {
    int key;
    Node left, right;

    public Node(int value) {
        key = value;
        left = right = null;
    }
}

public class Solution {
    public List<List<Integer>> printPaths(Node root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, sum, path, ans);

        return ans;
    }

    private void dfs(Node node, int curSum, List<Integer> path, List<List<Integer>> ans) {
        if (node == null)
            return;

        curSum -= node.key;
        path.add(node.key);

        if (curSum == 0 && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }

        dfs(node.left, curSum, path, ans);
        dfs(node.right, curSum, path, ans);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);

        // Finding paths with sum 22
        int targetSum = 22;
        List<List<Integer>> result = solution.printPaths(root, targetSum);

        // Displaying the result
        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : result) {
            for (int value : path) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
