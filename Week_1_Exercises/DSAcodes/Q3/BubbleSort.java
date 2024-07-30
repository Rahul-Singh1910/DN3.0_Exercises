import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("001", "Alice", 250.50),
            new Order("002", "Bob", 100.00),
            new Order("003", "Charlie", 150.75)
        };

        System.out.println("Before Bubble Sort:");
        System.out.println(Arrays.toString(orders));

        bubbleSort(orders);

        System.out.println("After Bubble Sort:");
        System.out.println(Arrays.toString(orders));
    }
}

