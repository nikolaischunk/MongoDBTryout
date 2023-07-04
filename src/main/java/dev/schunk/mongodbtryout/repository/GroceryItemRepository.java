package dev.schunk.mongodbtryout.repository;

import dev.schunk.mongodbtryout.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {

    @Query("{name:  '?0'}")
    GroceryItem findItemByName(String name);

    // query the database for all items with the given category
    // return only the name and quantity fields
    @Query(value = "{category:  '?0'}", fields = "{name : 1, quantity : 1}")
    List<GroceryItem> findAll(String category);

    // reusing the count method
    public long count();
}
