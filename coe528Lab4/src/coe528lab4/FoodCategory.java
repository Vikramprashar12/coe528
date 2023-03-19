/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab4;

import java.util.ArrayList;

/**
 *
 * @author Vikram Prashar
 */
public class FoodCategory extends FoodComponent {

    private ArrayList<FoodComponent> elements = new ArrayList<FoodComponent>();

    public FoodCategory(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for (FoodComponent f : elements) {
            sum += f.getPrice();
        }
        return sum;
    }

    @Override
    public void print(int level) {
        for (int i = 1; i <= level; i++) {
            System.out.print("\t");
        }
        System.out.println("FoodCategory: (" + super.name + ", " + this.getPrice() + ") contains:");
        for (FoodComponent f: elements) {
            f.print(level+1);
        }
    }

    @Override
    public void remove(FoodComponent f) {
        elements.remove(f);
    }

    @Override
    public void add(FoodComponent f) {
        elements.add(f);
    }

}
