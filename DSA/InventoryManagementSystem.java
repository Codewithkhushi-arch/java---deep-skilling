import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " | Qty: " + quantity + " | Price: ₹" + price;
    }
}

public class InventoryManagementSystem {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.quantity = newQuantity;
            product.price = newPrice;
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.addProduct(new Product(1, "Laptop", 10, 1000.0));
        ims.addProduct(new Product(2, "Mouse", 50, 20.0));
        
        System.out.println("Initial Inventory:");
        ims.displayInventory();
        
        System.out.println("\nUpdating Mouse Quantity:");
        ims.updateProduct(2, 45, 20.0);
        ims.displayInventory();
        
        System.out.println("\nDeleting Laptop:");
        ims.deleteProduct(1);
        ims.displayInventory();
    }
}
/*
Output:
Initial Inventory:
ID: 1 | Name: Laptop | Qty: 10 | Price: ₹1000.0
ID: 2 | Name: Mouse | Qty: 50 | Price: ₹20.0

Updating Mouse Quantity:
ID: 1 | Name: Laptop | Qty: 10 | Price: ₹1000.0
ID: 2 | Name: Mouse | Qty: 45 | Price: ₹20.0

Deleting Laptop:
ID: 2 | Name: Mouse | Qty: 45 | Price: ₹20.0
*/
