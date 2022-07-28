/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemafood;

/**
 *
 * @author Ikechukwu
 */
public class Food {
    String name,categoryString;
    int id;
    double price;
    int category; // Food category. 1 for Drinks, 2 for Confectionary, 3 for Snacks
    int quantity = 1; // 1 item by default
    
    public static final int DRINKS = 1;
    public static final int CONFECTIONARIES = 2;
    public static final int SNACKS = 3;
    
    public static final String DRINKS_STRING = "DRINK";
    public static final String CONFECTIONARIES_STRING = "CONFECTIONARY";
    public static final String SNACKS_STRING = "SNACK";

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
    public Food() {
    }

    public Food(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryString() {
        return categoryString;
    }

    public void setCategoryString(String categoryString) {
        this.categoryString = categoryString;
    }
    
    
}
