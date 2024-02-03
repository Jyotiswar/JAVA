class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {

    public long decimalValue(Node head) {
        long out = 0;
        long mod = 1000000007; // 1e9 + 7 in Java

        Node temp = head;

        while (temp != null) {
            out = (out << 1) % mod;
            out = (out + temp.data) % mod;
            temp = temp.next;
        }

        return out;
    }

    public static void main(String[] args) {
        // Example Usage:
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(1);

        Solution solution = new Solution();
        long result = solution.decimalValue(head);

        System.out.println("Decimal Value: " + result);
    }
}
