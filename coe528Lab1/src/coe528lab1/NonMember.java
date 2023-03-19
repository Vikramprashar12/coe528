package coe528lab1;

/**
 *
 * @author Vikram Prashar
 */
public class NonMember extends Passenger {

    public NonMember(int age, String name) {
        super(name, age);
        System.out.println("New NonMember has been made with name "+super.name+" and age "+super.age);
    }

    @Override
    public double applyDiscount(double price) {
        double postp;
        if (super.getAge() > 65) {
            postp = price * 0.9;
        } else {
            postp = price;
        }
        return postp;
    }

}
