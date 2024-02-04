import java.util.LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {

    private Node reverse(Node head) {
        Node prev = null, cur = head;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private LinkedList<Node> subtract(Node head1, Node head2) {
        LinkedList<Node> ans = new LinkedList<>();
        LinkedList<Node> second = new LinkedList<>();
        int carry = 0;

        while (head1 != null || head2 != null) {
            int cur = (head1 != null ? head1.data : 0) - (head2 != null ? head2.data : 0) - carry;
            carry = cur < 0;

            if (carry) {
                if ((head1 != null && head1.next != null) || (head2 != null && head2.next != null)) {
                    ans.add(new Node(10 + cur));
                    second.add(new Node(0));
                } else {
                    second.add(new Node(Math.abs(cur)));
                }
            } else {
                ans.add(new Node(cur));
                second.add(new Node(0));
            }

            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }

        if (carry) {
            return second;
        } else {
            return ans; // Null indicates that F >= S
        }
    }

    public Node subLinkedList(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);

        LinkedList<Node> res = subtract(head1, head2);
        Node final_ans;

        if (!res.isEmpty()) {
            head1 = res.getFirst();
            head2 = res.getLast();

            final_ans = subtract(head1, head2).getFirst();
        } else {
            final_ans = res.getFirst();
        }

        final_ans = reverse(final_ans);

        while (final_ans.data == 0 && final_ans.next != null)
            final_ans = final_ans.next;

        return final_ans;
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();

        Node head1 = new Node(3);
        head1.next = new Node(4);
        head1.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next = new Node(2);

        Node result = solution.subLinkedList(head1, head2);

        // Print the result or perform any additional operations as needed
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
