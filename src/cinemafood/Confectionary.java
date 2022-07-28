/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemafood;

/**
 *
 * @author Ikechukwu
 */
public class Confectionary extends Food{

    public Confectionary() {
        this.category = Food.CONFECTIONARIES;
        this.categoryString = Food.CONFECTIONARIES_STRING;
    }
    
    public Confectionary(String name, int id, double price) {
        super(name, id, price);
        this.category = Food.CONFECTIONARIES;
        this.categoryString = Food.CONFECTIONARIES_STRING;
    }
    
}
