import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example paths
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path1 = List.of(2, 4, 6);
        List<Integer> path2 = List.of(1, 3, 5);
        List<Integer> path3 = List.of(2, 2, 2);
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Check if it is possible
        boolean result = solution.isPossible(paths);

        // Display the result
        if (result) {
            System.out.println("It is possible.");
        } else {
            System.out.println("It is not possible.");
        }
    }
}

class Solution {
    public boolean isPossible(List<List<Integer>> paths) {
        for (List<Integer> path : paths) {
            int sum = 0;
            for (int num : path) {
                sum += num;
            }
            if (sum % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}

