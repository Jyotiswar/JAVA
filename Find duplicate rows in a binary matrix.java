import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> repeatedRows(int[][] matrix, int M, int N) {
        Map<String, Integer> mp = new HashMap<>();
        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                str.append(matrix[i][j] == 1 ? '1' : '0');
            }

            String key = str.toString();
            if (mp.containsKey(key)) {
                out.add(i);
            } else {
                mp.put(key, i);
            }
        }

        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage:
        int M = 3;
        int N = 4;
        int[][] matrix = {
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        List<Integer> result = solution.repeatedRows(matrix, M, N);
        System.out.println("Rows with duplicates: " + result);
    }
}
