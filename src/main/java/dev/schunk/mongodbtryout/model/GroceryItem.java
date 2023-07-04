package dev.schunk.mongodbtryout.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
public class GroceryItem {

    // If this is not sent, then mongo will create a unique id for each item
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;

    public GroceryItem(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "GroceryItem: " + this.name + " " + this.quantity + " " + this.category;
    }

    public String getQuantity() {
        return String.valueOf(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void printItemDetails() {
        System.out.println("Item Name: " + this.name + ", \nQuantity: " + this.quantity + ", \nItem Category: " + this.category);
    }
}
