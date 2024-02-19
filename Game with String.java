import java.util.*;

class Solution {
    public int minValue(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : map.values()) {
            pq.offer(count);
        }

        while (k > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            if (top > 1) {
                pq.offer(top - 1);
            }
            k--;
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int count = pq.poll();
            result += count * count;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abccc";
        int k = 1;
        System.out.println(solution.minValue(s, k)); // Output: 6
    }
}
