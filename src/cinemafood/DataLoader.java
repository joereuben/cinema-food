/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemafood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ikechukwu
 */
public class DataLoader {
    
    public static String DRINKS = "datafiles/Drinks.csv";
    public static String CONFECTIONARY = "datafiles/Confectionary.csv";
    public static String SNACKS = "datafiles/Snacks.csv";
    
    
    public static List<Food> loadDrinks(){
        List<Food> drinks = new ArrayList<>(); 

        try (BufferedReader br = new BufferedReader(new FileReader(DRINKS))) {
//             read the first line from the text file 
             String line = br.readLine();
             // loop until all lines are read 
             while (line != null) {
                 // use string.split to load a string array with the values from 
                // each line of // the file, using a comma as the delimiter 
                String[] attributes = line.split(",");
                Drink drink = createDrink(attributes);
                // adding book into ArrayList 
                drinks.add(drink);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine(); 
             } 
        } catch (IOException ioe) {
            ioe.printStackTrace(); 
        } 
        
        return drinks;

    }
      
    public static List<Food> loadConfectionaries(){
        List<Food> confectionarys = new ArrayList<>(); 

        try (BufferedReader br = new BufferedReader(new FileReader(CONFECTIONARY))) {
//             read the first line from the text file 
             String line = br.readLine();
             // loop until all lines are read 
             while (line != null) {
                 // use string.split to load a string array with the values from 
                // each line of // the file, using a comma as the delimiter 
                String[] attributes = line.split(",");
                Confectionary confectionary = createConfectionary(attributes);
                // adding book into ArrayList 
                confectionarys.add(confectionary);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine(); 
             } 
        } catch (IOException ioe) {
            ioe.printStackTrace(); 
        } 
        
        return confectionarys;

    }
    
    public static List<Food> loadSnacks(){
        List<Food> snacks = new ArrayList<>(); 
        
        try (BufferedReader br = new BufferedReader(new FileReader(SNACKS))) {
//             read the first line from the text file 
             String line = br.readLine();
             // loop until all lines are read 
             while (line != null) {
                 // use string.split to load a string array with the values from 
                // each line of // the file, using a comma as the delimiter 
                String[] attributes = line.split(",");
                Snack snack = createSnack(attributes);
                // adding book into ArrayList 
                snacks.add(snack);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine(); 
             } 
        } catch (IOException ioe) {
            ioe.printStackTrace(); 
        } 
        
        return snacks;

    }
    
    private static Drink createDrink(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        
        return new Drink(name, id, price);
    }
    
    private static Confectionary createConfectionary(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        
        return new Confectionary(name, id, price);
    }
    
    private static Snack createSnack(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        
        return new Snack(name, id, price);
    }
    
    public static boolean saveToFiles(List<Food> foods){
        try {
            File drinksFile = new File(DRINKS);
            File conFile = new File(CONFECTIONARY);
            File snacksFile = new File(SNACKS);
            
            File drinksBFile = new File("datafiles/Drinks-backup.csv");
            File conBFile = new File("datafiles/Confectionary-backup.csv");
            File snacksBFile = new File("datafiles/Snacks-backup.csv");
            
            Files.copy(drinksFile.toPath(), drinksBFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(conFile.toPath(), conBFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(snacksFile.toPath(), snacksBFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
            clearFiles();
            
            String datafile;
            for (Food food : foods) {
                switch (food.getCategory()) {
                    case Food.DRINKS:
                        datafile = DRINKS;
                        break;
                    case Food.CONFECTIONARIES:
                        datafile = CONFECTIONARY;
                        break;
                    default:
                        datafile = SNACKS;
                        break;
                }
                
                FileWriter fileWriter = new FileWriter(datafile,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(food.getId()+",");
                bufferedWriter.write(food.getName()+",");
                bufferedWriter.write(String.valueOf(food.getPrice()));
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            
            
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean clearFiles(){
        try {
            FileWriter fileWriter = new FileWriter(DRINKS);            
            FileWriter fileWriter2 = new FileWriter(CONFECTIONARY);            
            FileWriter fileWriter3 = new FileWriter(SNACKS);            
            fileWriter.write("");
            fileWriter2.write("");
            fileWriter3.write("");
            
            fileWriter.close();
            fileWriter2.close();
            fileWriter3.close();
            return true;
        } catch (IOException ex) {
            return false;
//            Logger.getLogger(CartReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
