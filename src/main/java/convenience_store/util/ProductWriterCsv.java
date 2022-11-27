package convenience_store.util;

import convenience_store.enums.Category;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductWriterCsv {
    static String[] header = {"productName", "category", "productId", "price", "quantity"};

    static String[] productName = {"Milk", "Milo", "Yam", "Mayonnaise", "Sugar",
            "Omo", "Shampoo", "Deodorant", "Dental flush", "Toothpaste",
            "Television", "Fridge", "Clock", "Oven", "Laptop",
            "Antacids", "Hydrogen-peroxide", "Alcohol", "Methylated Spirit", "Bandage"};

    static Category[] categories = {Category.FOOD, Category.TOILETRIES, Category.ELECTRONICS,  Category.HEALTH_CARE};

    static String[] productId = {"LSS001", "LSS002", "LSS003", "LSS004", "LSS005",
            "LSS006", "LSS007", "LSS008", "LSS009", "LSS010",
            "LSS011", "LSS012", "LSS013", "LSS014", "LSS015",
            "LSS016", "LSS017", "LSS018", "LSS019", "LSS020"};

    static double[] price = {1200d, 1300d, 1400d, 2000d, 800d, 150d, 500d, 800d, 800d, 500d,
            150000d, 200000d, 2000d, 18000d, 800000d, 250d, 250d, 200d, 300d, 150d};

    static Integer[] quantity = {12, 0, 9, 8, 11, 3, 11, 2, 9, 10, 11, 12, 10, 8, 5, 9, 8, 6, 3, 9};

    public static void main(String[] args) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("convenience-store/src/main/resources/products.csv"))){
            for(String head : header) {
                writer.write(head + ",");
            }
            writer.write("\n");
            for (int i = 0; i < 20; ++i) {
                int j = i / 5;
                writer.write(productName[i] + "," + categories[j] + "," + productId[i] + "," + price[i] + "," + quantity[i] + "\n");
            }

            System.out.println("product.csv file created successfully");

        } catch(IOException ioException) {
            throw new RuntimeException("File or Directory does not exist");
        }
    }
}
