import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey()
        );

        for (int i = 0; i < N; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            pq.clear();
            pq.addAll(frequencyMap.entrySet());

            ArrayList<Integer> currentIteration = new ArrayList<>();
            int count = 0;
            while (!pq.isEmpty() && count < K) {
                currentIteration.add(pq.poll().getKey());
                count++;
            }
            result.add(currentIteration);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] inputArray = {1, 2, 1, 3, 2, 4, 5, 1, 2, 3};
        int N = inputArray.length;
        int K = 3;

        ArrayList<ArrayList<Integer>> result = kTop(inputArray, N, K);

        System.out.println("Top " + K + " elements at each iteration:");
        for (ArrayList<Integer> iteration : result) {
            System.out.println(iteration);
        }
    }
}
