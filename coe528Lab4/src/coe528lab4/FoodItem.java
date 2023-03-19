/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab4;

/**
 *
 * @author Vikram Prashar
 */
public class FoodItem extends FoodComponent {

    private double price;

    public FoodItem(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println("FoodItem: " + super.name + ", " + price);
    }

    @Override
    public void remove(FoodComponent f) {

    }

    @Override
    public void add(FoodComponent f) {

    }

}
