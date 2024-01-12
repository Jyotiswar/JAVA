import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> temp = new Stack<>();
        Queue<Integer> ans = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            temp.push(q.poll());
        }

        while (!temp.isEmpty()) {
            ans.add(temp.pop());
        }

        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Queue<Integer> queue = new LinkedList<>();
        // Add elements to the queue for testing
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        int k = 3; // Replace with your desired value of k

        Queue<Integer> result = solution.modifyQueue(queue, k);

        // Display the modified queue
        System.out.println("Modified Queue: " + result);
    }
}
