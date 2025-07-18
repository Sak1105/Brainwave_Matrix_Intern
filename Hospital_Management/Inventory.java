import java.util.ArrayList;

class Inventory {
    private ArrayList<Item> supplies;

    public Inventory() {
        supplies = new ArrayList<>();
    }

    // Add or update the quantity of an item in stock
    public void updateStock(String itemName, int quantity) {
        boolean found = false;
        for (Item item : supplies) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.updateQuantity(quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            supplies.add(new Item(itemName, quantity));
        }
    }

    // Check the stock of a specific item
    public int checkStock(String itemName) {
        for (Item item : supplies) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item.getQuantity();
            }
        }
        return 0; // Item not found
    }

    // Display the entire inventory stock
    public void displayStock() {
        System.out.println("Inventory Stock:");
        if (supplies.isEmpty()) {
            System.out.println("No items in stock.");
        } else {
            for (Item item : supplies) {
                System.out.println(item);
            }
        }
    }
}
