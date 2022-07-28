/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemafood;

/**
 *
 * @author Ikechukwu
 */
public class Drink extends Food{

  
    public Drink() {
        this.category = Food.DRINKS;
        this.categoryString = Food.DRINKS_STRING;
    }

    public Drink(String name, int id, double price) {
        super(name, id, price);
        this.category = Food.DRINKS;
        this.categoryString = Food.DRINKS_STRING;
    }
    
}
