class Solution {
    public int sumOfLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.data;
        }
        
        int leftSum = sumOfLeafNodes(root.left);
        int rightSum = sumOfLeafNodes(root.right);
        
        return leftSum + rightSum;
    }
}

class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
