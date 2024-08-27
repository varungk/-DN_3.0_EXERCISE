import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    private int itemId;
    private String itemName;
    private String type;

    public Item(int itemId, String itemName, String type) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.type = type;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Item[ID=" + itemId + ", Name=" + itemName + ", Type=" + type + "]";
    }
}

class SearchUtility {

    public static Item linearSearch(Item[] items, String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public static Item binarySearch(Item[] items, String itemName) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = itemName.compareToIgnoreCase(items[mid].getItemName());

            if (result == 0) {
                return items[mid];
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Item[] items = {
            new Item(1, "Laptop", "Electronics"),
            new Item(2, "Smartphone", "Electronics"),
            new Item(3, "Book", "Literature")
        };

        System.out.println("Available Items:");
        for (Item item : items) {
            System.out.println(item);
        }

        System.out.print("\nEnter the item name to search: ");
        String itemName = input.nextLine();

        System.out.println("\nSearching for '" + itemName + "' using Linear Search:");
        Item result = linearSearch(items, itemName);
        System.out.println(result != null ? result : "Item not found");

        // Sort items by name for binary search
        Arrays.sort(items, Comparator.comparing(Item::getItemName));

        System.out.println("\nSearching for '" + itemName + "' using Binary Search:");
        result = binarySearch(items, itemName);
        System.out.println(result != null ? result : "Item not found");

        input.close();
    }
}
