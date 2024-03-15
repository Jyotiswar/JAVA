class Solution {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public void sort(Node head) {
        if (head == null || head.next == null)
            return;

        Node asc = head, des = head.next;
        Node revStart = des;

        while (des != null && des.next != null) {
            asc.next = des.next;
            asc = asc.next;
            des.next = asc.next;
            des = des.next;
        }

        Node temp = reverse(revStart);
        asc.next = temp;
    }
}
