import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static boolean func(String a, String b) {
        return (a + b).compareTo(b + a) > 0;
    }

    public String printLargest(int n, String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a);
            }
        }.reversed());

        StringBuilder out = new StringBuilder();
        for (String s : arr) {
            out.append(s);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"54", "546", "548", "60"}; // Example array
        String result = solution.printLargest(arr.length, arr);
        System.out.println(result);
    }
}
