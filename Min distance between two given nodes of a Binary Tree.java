class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Solution {
    int ans;

    private int solve(Node root, int a, int b) {
        if (root == null || ans > 0)
            return 0;

        int l = solve(root.left, a, b);
        int r = solve(root.right, a, b);

        if ((root.data == a || root.data == b)) {
            if (l != 0)
                ans = l;
            else if (r != 0)
                ans = r;
            else
                return 1;
        }

        if (l != 0 && r != 0)
            ans = l + r;
        else if (l != 0)
            return l + 1;
        else if (r != 0)
            return r + 1;

        return 0;
    }

    public int findDist(Node root, int a, int b) {
        if (a == b)
            return 0;

        ans = 0;
        solve(root, a, b);
        return ans;
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

        int a = 4, b = 7;
        int distance = solution.findDist(root, a, b);
        System.out.println("Distance between nodes " + a + " and " + b + ": " + distance);
    }
}
