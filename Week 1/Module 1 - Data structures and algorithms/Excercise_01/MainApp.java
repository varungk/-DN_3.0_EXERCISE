import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Item class to represent each product in the stock
class Item {
    private int itemId;
    private String itemName;
    private int stock;
    private double cost;

    // Constructor to initialize item attributes
    public Item(int itemId, String itemName, int stock, double cost) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.stock = stock;
        this.cost = cost;
    }

    // Getters and setters for the item attributes
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item[ID=" + itemId + ", Name=" + itemName + ", Stock=" + stock + ", Cost=" + cost + "]";
    }
}

// StockManager class to handle the collection of items
class StockManager {
    private Map<Integer, Item> inventory;

    // Constructor initializes the item map
    public StockManager() {
        inventory = new HashMap<>();
    }

    // Method to add an item to the inventory
    public void addItem(Item item) {
        if (inventory.containsKey(item.getItemId())) {
            throw new IllegalArgumentException("Item ID already exists.");
        }
        inventory.put(item.getItemId(), item);
    }

    // Method to remove an item from the inventory
    public void removeItem(int itemId) {
        if (!inventory.containsKey(itemId)) {
            throw new IllegalArgumentException("Item not found.");
        }
        inventory.remove(itemId);
    }

    // Method to modify item details
    public void modifyItem(int itemId, Integer stock, Double cost) {
        Item item = inventory.get(itemId);
        if (item == null) {
            throw new IllegalArgumentException("Item not found.");
        }
        if (stock != null) {
            item.setStock(stock);
        }
        if (cost != null) {
            item.setCost(cost);
        }
    }

    // Method to display all items in the inventory
    public void listItems() {
        for (Item item : inventory.values()) {
            System.out.println(item);
        }
    }

    // Method to retrieve an item by its ID
    public Item fetchItem(int itemId) {
        return inventory.get(itemId);
    }
}

// MainApp class containing the entry point of the application
public class MainApp {
    public static void main(String[] args) {
        StockManager stockManager = new StockManager();
        Scanner input = new Scanner(System.in);

        // Infinite loop to keep the program running until user decides to exit
        while (true) {
            // Display menu options to the user
            System.out.println("Stock Management System:");
            System.out.println("1. Add Item");
            System.out.println("2. Modify Item");
            System.out.println("3. Remove Item");
            System.out.println("4. View Item");
            System.out.println("5. List All Items");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = input.nextInt();

            // Switch case to handle the user's choice
            switch (option) {
                case 1:
                    // Adding a new item
                    System.out.print("Enter Item ID: ");
                    int itemId = input.nextInt();
                    input.nextLine();  // Consume newline
                    System.out.print("Enter Item Name: ");
                    String itemName = input.nextLine();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = input.nextInt();
                    System.out.print("Enter Cost: ");
                    double cost = input.nextDouble();
                    Item item = new Item(itemId, itemName, stock, cost);
                    stockManager.addItem(item);
                    break;
                case 2:
                    // Modifying an existing item
                    System.out.print("Enter Item ID to modify: ");
                    itemId = input.nextInt();
                    System.out.print("Enter new Stock Quantity (or -1 to skip): ");
                    stock = input.nextInt();
                    System.out.print("Enter new Cost (or -1 to skip): ");
                    cost = input.nextDouble();
                    stockManager.modifyItem(itemId, stock == -1 ? null : stock, cost == -1 ? null : cost);
                    break;
                case 3:
                    // Removing an item
                    System.out.print("Enter Item ID to remove: ");
                    itemId = input.nextInt();
                    stockManager.removeItem(itemId);
                    break;
                case 4:
                    // Viewing a specific item
                    System.out.print("Enter Item ID to view: ");
                    itemId = input.nextInt();
                    Item itm = stockManager.fetchItem(itemId);
                    if (itm != null) {
                        System.out.println(itm);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 5:
                    // Listing all items
                    stockManager.listItems();
                    break;
                case 6:
                    // Exiting the program
                    System.out.println("Exiting...");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    // Handling invalid input
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
