import java.util.ArrayList;
import java.util.Collections;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    public Node insertionSort(Node head) {
        ArrayList<Integer> ans = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            ans.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(ans);

        temp = head;
        int i = 0;

        while (temp != null) {
            temp.data = ans.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    // Example of how to use the Solution class
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a linked list for testing
        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);

        // Print original linked list
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Sort the linked list using insertion sort
        Node sortedHead = solution.insertionSort(head);

        // Print sorted linked list
        System.out.println("\nLinked List after Insertion Sort:");
        printLinkedList(sortedHead);
    }

    // Helper method to print a linked list
    private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
