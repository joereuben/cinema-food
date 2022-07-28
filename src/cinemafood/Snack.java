/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemafood;

/**
 *
 * @author Ikechukwu
 */
public class Snack extends Food{

    public Snack() {
        this.category = Food.SNACKS;
        this.categoryString = Food.SNACKS_STRING;
    }

    public Snack(String name, int id, double price) {
        super(name, id, price);
        this.category = Food.SNACKS;
        this.categoryString = Food.SNACKS_STRING;
    }
    
}
