class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
}

public class SortingCustomerOrders {
    // Bubble Sort Implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort Implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(1, "Alice", 250.5),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 300.0)
        };
        
        System.out.println("Before Bubble Sort:");
        for (Order o : orders1) System.out.println(o.customerName + " - " + o.totalPrice);
        
        bubbleSort(orders1);
        System.out.println("\nAfter Bubble Sort:");
        for (Order o : orders1) System.out.println(o.customerName + " - " + o.totalPrice);
        
        Order[] orders2 = {
            new Order(4, "Dave", 500.0),
            new Order(5, "Eve", 100.0),
            new Order(6, "Frank", 450.0)
        };
        
        System.out.println("\nBefore Quick Sort:");
        for (Order o : orders2) System.out.println(o.customerName + " - " + o.totalPrice);
        
        quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order o : orders2) System.out.println(o.customerName + " - " + o.totalPrice);
    }
}
/*
Output:
Before Bubble Sort:
Alice - 250.5
Bob - 150.0
Charlie - 300.0

After Bubble Sort:
Bob - 150.0
Alice - 250.5
Charlie - 300.0

Before Quick Sort:
Dave - 500.0
Eve - 100.0
Frank - 450.0

After Quick Sort:
Eve - 100.0
Frank - 450.0
Dave - 500.0
*/
