/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab1;

/**
 *
 * @author Vikram Prashar
 */
public class Member extends Passenger {

    private int yofm;

    public Member(int yofm, int age, String name) {
        super(name, age);
        this.yofm = yofm;
        System.out.println("New Member has been made with name "+super.name+" and age "+super.age);
    }

    @Override
    public double applyDiscount(double price) {
        double postp;
        if (yofm > 5) {
            postp = price * 0.5;
        } else if ((yofm > 1) && (yofm <= 5)) {
            postp = price * 0.9;
        } else {
            postp = price;
        }
        return postp;
    }
}