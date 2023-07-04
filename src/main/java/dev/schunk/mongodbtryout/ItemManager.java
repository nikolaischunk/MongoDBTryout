package dev.schunk.mongodbtryout;

import dev.schunk.mongodbtryout.model.GroceryItem;
import dev.schunk.mongodbtryout.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemManager {

    @Autowired
    GroceryItemRepository groceryItemRepo;

    public ItemManager() {
    }

    void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Apple", 5, "Fruit"));
        groceryItemRepo.save(new GroceryItem("Orange", 10, "Fruit"));
        groceryItemRepo.save(new GroceryItem("Banana", 15, "Fruit"));
        groceryItemRepo.save(new GroceryItem("Milk", 20, "Dairy"));
        groceryItemRepo.save(new GroceryItem("Cheese", 25, "Dairy"));
        groceryItemRepo.save(new GroceryItem("Bread", 35, "Bakery"));
        System.out.println("Data creation finished...");
    }

    public void showAllGroceryItems() {
        // equals `groceryItemRepo.findAll().forEach(item -> item.printItemDetails());`
        groceryItemRepo.findAll().forEach(GroceryItem::printItemDetails);
    }

    public void getItemByName(String name) {
        System.out.println("Getting item by name: " + name);
        GroceryItem item = groceryItemRepo.findItemByName(name);
        if (item != null) {
            item.printItemDetails();
        } else {
            System.out.println("Item not found");
        }
    }

    public void getAllItemsByCategory(String category) {
        System.out.println("Getting items by category: " + category);
        groceryItemRepo.findAll(category).forEach(GroceryItem::printItemDetails);
    }

    public void findCountOfGroceryItems() {
        long count = groceryItemRepo.count();
        System.out.println("Number of documents in the collection: " + count);
    }

    public void updateCategoryName(String oldName, String newName) {
        System.out.println("Updating category name from " + oldName + " to " + newName);
        List<GroceryItem> groceryItemList = groceryItemRepo.findAll(oldName);
        groceryItemList.forEach(item -> item.setCategory(newName));
        List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(groceryItemList);
        System.out.println("Successfully updated " + itemsUpdated.size() + " items");
    }

    public void deleteGroceryItem(String id) {
        groceryItemRepo.deleteById(id);
        System.out.println("Successfully deleted item with id: " + id);
    }

    public void deleteAllGroceryItems() {
        groceryItemRepo.deleteAll();
        System.out.println("Successfully deleted all items");
    }
}
