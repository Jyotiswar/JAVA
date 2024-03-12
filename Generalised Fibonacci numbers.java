import java.util.Arrays;

public class Solution {
    public int[][] mult(int[][] mat1, int[][] mat2, int m) {
        int[][] mat = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mat[i][j] += mat1[i][k] * mat2[k][j];
                }
                mat[i][j] %= m;
            }
        }
        return mat;
    }

    public int[][] exp(int[][] mat, int n, int m) {
        if (n == 0) {
            return new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        } else if (n == 1) {
            return mat;
        } else {
            int[][] math = exp(mat, n / 2, m);
            int[][] matf = mult(math, math, m);
            if (n % 2 == 1) {
                matf = mult(matf, mat, m);
            }
            return matf;
        }
    }

    public int genFibNum(int a, int b, int c, int n, int m) {
        if (n <= 2) {
            return 1 % m;
        } else {
            int[][] base = {{a, b, c}, {1, 0, 0}, {0, 0, 1}};
            int[][] result = exp(base, n - 2, m);
            int sum = Arrays.stream(result[0]).sum() % m;
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 3;
        int b = 3;
        int c = 3;
        int n = 3;
        int m = 5;
        int result = solution.genFibNum(a, b, c, n, m);
        System.out.println("Result: " + result);
    }
}
