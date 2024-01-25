import java.util.*;

public class Solution {
    private boolean[] isPrime;

    public void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int solve(int num1, int num2) {
        isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);
        sieve();

        String target = String.valueOf(num2);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(String.valueOf(num1));
        visited.add(String.valueOf(num1));
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                String perm;

                if (Objects.equals(current, target))
                    return level;

                for (int i = 0; i < 4; ++i) {
                    perm = current;
                    for (char c = '0'; c <= '9'; ++c) {
                        if (i == 0 && c == '0')
                            continue;

                        perm = perm.substring(0, i) + c + perm.substring(i + 1);
                        if (isPrime[Integer.parseInt(perm)] && !visited.contains(perm)) {
                            visited.add(perm);
                            queue.offer(perm);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int result = solution.solve(1033, 8179);
        System.out.println("Result: " + result);
    }
}
