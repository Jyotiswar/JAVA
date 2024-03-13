import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> matrixDiagonally(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<Integer> ans = new ArrayList<>();
        int row = 0, col = 0;
        int n = mat.size();

        while (ans.size() < n * n) {
            while (row >= 0 && col < n) {
                if (row >= 0 && col >= 0 && row < n && col < n) {
                    ans.add(mat.get(row).get(col));
                    mat.get(row).set(col, Integer.MAX_VALUE);
                }
                row--;
                col++;
            }
            if (ans.size() == n * n) {
                break;
            }

            row = Math.max(row, 0);
            col = Math.min(col, n - 1);

            while (mat.get(row).get(col) == Integer.MAX_VALUE) {
                row++;
            }

            while (col >= 0 && row < n) {
                if (row >= 0 && col >= 0 && row < n && col < n) {
                    ans.add(mat.get(row).get(col));
                    mat.get(row).set(col, Integer.MAX_VALUE);
                }
                row++;
                col--;
            }
            if (ans.size() == n * n) {
                break;
            }

            row = Math.min(row, n - 1);
            col = Math.max(col, 0);

            while (mat.get(row).get(col) == Integer.MAX_VALUE) {
                col++;
            }
        }
        return ans;
    }
}
