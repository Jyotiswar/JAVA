import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    List<Node> neighbors;

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node newStart = new Node(node.val);
        Map<Integer, Node> visited = new HashMap<>();

        dfs(newStart, node, visited);

        return newStart;
    }

    private void dfs(Node newNode, Node orgNode, Map<Integer, Node> visited) {
        visited.put(newNode.val, newNode);

        for (Node child : orgNode.neighbors) {
            Node newChild;
            if (!visited.containsKey(child.val)) {
                newChild = new Node(child.val);
                newNode.neighbors.add(newChild);
                dfs(newChild, child, visited);
            } else {
                newChild = visited.get(child.val);
                newNode.neighbors.add(newChild);
            }
        }
    }
}
