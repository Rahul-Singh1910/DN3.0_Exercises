import java.util.HashMap;

public class InventoryManagement {
    private HashMap<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    // Add product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Print inventory
    public void printInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();

        Product p1 = new Product(1, "Laptop", 10, 999.99);
        Product p2 = new Product(2, "Smartphone", 20, 599.99);

        im.addProduct(p1);
        im.addProduct(p2);

        System.out.println("Inventory after addition:");
        im.printInventory();

        p1.setQuantity(15);
        im.updateProduct(p1);

        System.out.println("Inventory after update:");
        im.printInventory();

        im.deleteProduct(2);

        System.out.println("Inventory after deletion:");
        im.printInventory();
    }
}


