/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemafood;

import javax.swing.JButton;

/**
 *
 * @author Ikechukwu
 */
public class CartButton extends JButton{
    
    private String category;
    private boolean isAdded = false;
    private Food food;

    public CartButton(){
        super("Add To Cart");
    }
    
    public CartButton(String text){
        super(text);
    }


    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setIsAdded(boolean isAdded) {
        this.isAdded = isAdded;
    }
}
