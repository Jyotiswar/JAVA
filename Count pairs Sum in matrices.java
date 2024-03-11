import java.util.ArrayList;

public class Solution {
    public int countPairs(ArrayList<ArrayList<Integer>> mat1, ArrayList<ArrayList<Integer>> mat2, int n, int x) {
        int sz = n * n;
        int l = 0, r = sz - 1;
        int cnt = 0;

        while (l < sz && r >= 0) {
            int sum = mat1.get(l / n).get(l % n) + mat2.get(r / n).get(r % n);

            if (sum == x) {
                l++;
                r--;
                cnt++;
            } else if (sum > x)
                r--;
            else
                l++;
        }

        return cnt;
    }
}
