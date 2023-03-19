/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.ArrayList;

/**
 *
 * @author Vikram Prashar
 */
class ObserverPattern {

    public static void main(String[] args) {

        ItemsBought a = new ItemsBought();

        a.attach(new DollarView());

        a.attach(new PercentView());

        a.buyItem("book", 2.00);

        System.out.println("----------------------");

        a.buyItem("cup", 3.00);

        System.out.println("----------------------");

        a.buyItem("bottle", 5.00);

        System.out.println("----------------------");

    }

}

class Item {

    private String name;
    private double price;

    public Item(String s, double p) {
        name = s;
        price = p;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}

abstract class Observer {

    public abstract void handle(ItemsBought ib);

}

abstract class Subject {

    public abstract void attach(Observer ob);

}

class ItemsBought extends Subject {

    private ArrayList<Observer> observe;
    private ArrayList<Item> items;
    private double totalprice;

    public ItemsBought() {
        observe = new ArrayList<Observer>();
        items = new ArrayList<Item>();
        totalprice = 0;
    }

    public void buyItem(String s, double p) {

        Item item = new Item(s, p);
        items.add(item);
        totalprice += p;

        for (Observer ob : observe) {
            ob.handle(this);
        }
    }

    public void attach(Observer ob) {
        observe.add(ob);
    }

    public double getSum() {
        return totalprice;
    }

    public Item getItem(int i) {
        return items.get(i);
    }

    public int getNumberOfItems() {
        return items.size();
    }
}

class DollarView extends Observer {

    @Override
    public void handle(ItemsBought ib) {
        System.out.println("Current Dollar view:");
        for (int i = 0; i < ib.getNumberOfItems(); i++) {
            Item it = ib.getItem(i);
            System.out.println(it.getName() + " : " + it.getPrice());
        }
    }
}

class PercentView extends Observer {

    @Override
    public void handle(ItemsBought ib) {
        double sum = ib.getSum();
        
        System.out.println("Current Percent view:");
        for (int i = 0; i < ib.getNumberOfItems(); i++) {
            Item it = ib.getItem(i);
            double percent = (it.getPrice() / sum) * 100;
            System.out.println(it.getName() + " : " + percent);
        }

    }

}
