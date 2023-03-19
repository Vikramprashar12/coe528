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
public abstract class FoodComponent {

    protected String name;

    protected FoodComponent(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public abstract void print(int level);

    public abstract void remove(FoodComponent f);

    public abstract void add(FoodComponent f);

}
