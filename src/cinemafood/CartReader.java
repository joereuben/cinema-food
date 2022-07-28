/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemafood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ikechukwu
 */
public class CartReader {
    
    private static String CART_FILE = "datafiles/cart.txt";
    private static String EOL = "\n";
    
    public static boolean addToCart(Food food){
        try {
            FileWriter fileWriter = new FileWriter(CART_FILE,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(food.getId()+",");
            bufferedWriter.write(food.getName()+",");
            bufferedWriter.write(food.getPrice()+",");
            bufferedWriter.write(String.valueOf(food.getCategory()));
            bufferedWriter.newLine();
            
            bufferedWriter.close();
            return true;
        } catch (IOException ex) {
            return false;
//            Logger.getLogger(CartReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean removeFromCart(Food food){
        List<Food> foods = readCart();
        for (Food food1 : foods) {
            if ((food.getId() == food1.getId()) && (food.getCategory() == food1.getCategory())) {
                foods.remove(food1);
                break;
            }
        }
        saveToCart(foods);
        return true;
    }
    
    public static boolean clearCart(){
        try {
            FileWriter fileWriter = new FileWriter(CART_FILE);            
            fileWriter.write("");
            
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            return false;
//            Logger.getLogger(CartReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isFoodInCart(Food food){
        List<Food> foods = readCart();
        for (Food food1 : foods) {
            if ((food.getId() == food1.getId()) && (food.getCategory() == food1.getCategory())) {
                return true;
            }
        }
        return false;
    }
    
    public static List<Food> readCart(){
        List<Food> foods = new ArrayList<>(); 
        try {
            FileReader reader = new FileReader(CART_FILE);
            var bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                foods.add(createFood(data));
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }
    
    public static boolean saveToCart(List<Food> foods){
        try {
            FileWriter fileWriter = new FileWriter(CART_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for (Food food : foods) {

                bufferedWriter.write(food.getId()+",");
                bufferedWriter.write(food.getName()+",");
                bufferedWriter.write(food.getPrice()+",");
                bufferedWriter.write(String.valueOf(food.getCategory()));
                bufferedWriter.newLine();               

            }
            bufferedWriter.close();
        } catch (IOException ex) {
            return false;
//            Logger.getLogger(CartReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    private static Food createFood(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        int category = Integer.parseInt(data[3]);
        
        Food food = new Food(name, id, price);
        food.setCategory(category);
        
        switch (category) {
            case Food.DRINKS -> food.setCategoryString(Food.DRINKS_STRING);
            case Food.CONFECTIONARIES -> food.setCategoryString(Food.CONFECTIONARIES_STRING);
            case Food.SNACKS -> food.setCategoryString(Food.SNACKS_STRING);
            default -> {
            }
        }
        
        return food;
    }
}
