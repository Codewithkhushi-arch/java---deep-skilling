import java.util.Arrays;
import java.util.Comparator;

class ProductSearch {
    int productId;
    String productName;
    String category;

    public ProductSearch(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommercePlatformSearchFunction {
    public static ProductSearch linearSearch(ProductSearch[] products, int targetId) {
        for (ProductSearch p : products) {
            if (p.productId == targetId) return p;
        }
        return null;
    }

    public static ProductSearch binarySearch(ProductSearch[] products, int targetId) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products[mid].productId == targetId) return products[mid];
            if (products[mid].productId < targetId) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        ProductSearch[] products = {
            new ProductSearch(1, "Laptop", "Electronics"),
            new ProductSearch(2, "Smartphone", "Electronics"),
            new ProductSearch(3, "Tablet", "Electronics")
        };
        
        System.out.println("Linear Search for 2: " + (linearSearch(products, 2) != null ? "Found" : "Not Found"));
        System.out.println("Binary Search for 3: " + (binarySearch(products, 3) != null ? "Found" : "Not Found"));
    }
}
/*
Output:
Linear Search for 2: Found
Binary Search for 3: Found
*/
