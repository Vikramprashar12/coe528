package coe528lab1;

/**
 *
 * @author Vikram Prashar
 */
public class Ticket {

    private static int ticknum = 1;
    private int sticknum;
    private Passenger p;
    private Flight f;
    private double price;

    public Ticket(Passenger p, Flight f, double price) {
        this.p = p;
        this.f = f;
        this.price = price;
        this.sticknum = ticknum;
        ticknum++;
    }

    public void setP(Passenger p) {
        this.p = p;
    }

    public void setF(Flight f) {
        this.f = f;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTickNum(int ticknum) {
        this.sticknum = ticknum;
    }

    public Flight getFlight() {
        return f;
    }

    public Passenger getPass() {
        return p;
    }

    public double getPrice() {
        return price;
    }

    public int getTickNum() {
        return sticknum;
    }

    @Override
    public String toString() {
        String r = p.getName() + ", " + f.toString() + ", Ticket Price: " + this.price;
        return r;
    }
    

}
