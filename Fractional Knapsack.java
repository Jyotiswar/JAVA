import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Solution {
    public double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, Comparator.comparingDouble(a -> (a.value * 1.0) / a.weight).reversed());

        double value = 0;

        // Filling the knapsack
        for (int i = 0; i < n; i++) {
            Item item = arr[i];

            if (item.weight <= W) {
                value += item.value;
                W -= item.weight;
            } else {
                value += (item.value * 1.0) * W / item.weight;
                break;
            }
        }

        return value;
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int knapsackCapacity = 50;
        int numberOfItems = items.length;
        double result = solution.fractionalKnapsack(knapsackCapacity, items, numberOfItems);
        System.out.println("Maximum value in Knapsack: " + result);
    }
}
