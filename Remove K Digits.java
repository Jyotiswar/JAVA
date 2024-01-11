import java.util.Stack;

public class Solution {
    public String removeKdigits(String S, int K) {
        Pair<Integer, Integer> last = new Pair<>(0, K);
        int n = S.length();
        int index = 0;

        while (index < n) {
            if (S.charAt(index) != '0') {
                if (K > 0)
                    K--;
                else
                    break;

                index++;
            } else {
                while (index < n && S.charAt(index) == '0') {
                    index++;
                }

                last = new Pair<>(index, K);
            }
        }

        Stack<Integer> num = new Stack<>();
        int start = last.getKey();
        K = last.getValue();

        for (int i = start; i < n; i++) {
            while (!num.isEmpty() && num.peek() > (S.charAt(i) - '0') && K > 0) {
                K--;
                num.pop();
            }

            num.push(S.charAt(i) - '0');
        }

        while (!num.isEmpty() && K > 0) {
            K--;
            num.pop();
        }

        StringBuilder ans = new StringBuilder();

        while (!num.isEmpty()) {
            ans.append(num.pop());
        }

        ans.reverse();

        if (ans.length() == 0)
            ans.append("0");

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.removeKdigits("1432219", 3);
        System.out.println("Result: " + result);
    }
}
