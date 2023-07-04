package dev.schunk.mongodbtryout;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "dev.schunk.mongodbtryout.repository")
@SpringBootApplication
public class MongoDbTryoutApplication implements CommandLineRunner {


    ItemManager itemManager = new ItemManager();

    public static void main(String[] args) {
        SpringApplication.run(MongoDbTryoutApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");
        itemManager.createGroceryItems();
        System.out.println("-------------SHOW ALL GROCERY ITEMS-------------------------------\n");
        itemManager.showAllGroceryItems();
        System.out.println("-------------GET ITEM BY NAME-------------------------------\n");
        itemManager.getItemByName("Milk");
        System.out.println("-------------GET ALL ITEMS BY CATEGORY-------------------------------\n");
        itemManager.getAllItemsByCategory("Dairy");
        System.out.println("-------------UPDATE CATEGORY NAME-------------------------------\n");
        itemManager.updateCategoryName("Dairy", "Dairy Products");
        System.out.println("-------------DELETE A ITEM-------------------------------\n");
        itemManager.deleteGroceryItem("Bread");
        System.out.println("-------------SHOW COUNT OF GROCERY ITEMS-------------------------------\n");
        itemManager.findCountOfGroceryItems();
        System.out.println("-------------DONE-------------------------------\n");

    }
}
