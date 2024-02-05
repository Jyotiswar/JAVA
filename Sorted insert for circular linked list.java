class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {

    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        Node next = curr.next;

        if (data <= curr.data) {
            newNode.next = head;
            while (curr.next != head)
                curr = curr.next;

            curr.next = newNode;
            return newNode;
        }

        while (next != head && data > next.data) {
            curr = next;
            next = next.next;
        }

        curr.next = newNode;
        newNode.next = next;

        return head;
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();

        Node head = null;

        // Inserting elements into the sorted circular linked list
        head = solution.sortedInsert(head, 5);
        head = solution.sortedInsert(head, 2);
        head = solution.sortedInsert(head, 8);
        head = solution.sortedInsert(head, 1);

        // Print the sorted circular linked list
        solution.printCircularLinkedList(head);
    }

    // Utility method to print the circular linked list
    private void printCircularLinkedList(Node head) {
        if (head == null)
            return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }
}
