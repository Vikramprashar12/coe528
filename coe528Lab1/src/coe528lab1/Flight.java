package coe528lab1;

public class Flight {

    protected int flightnum, capacity, seatsLeft;
    protected double origPrice;
    protected String origin, destination, depTime;

    public Flight(int flightnum, int capacity, double origPrice, String origin, String destination, String depTime) {
        this.flightnum = flightnum;
        this.capacity = capacity;
        this.depTime = depTime;
        this.origPrice = origPrice;
        this.seatsLeft = capacity;
        if (origin.equals(destination)) {
            throw new IllegalArgumentException("The origin and destination are the same, this is not allowed.");
        } else {
            this.origin = origin;
            this.destination = destination;
        }
    }

    public int getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(int flightnum) {
        this.flightnum = flightnum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        if ((seatsLeft > capacity) || (seatsLeft < 0)) {
            throw new IllegalArgumentException("The number of seats left cannot be larger than the capacity or negative");
        } else {
            this.seatsLeft = seatsLeft;
        }
    }

    public double getOrigPrice() {
        return origPrice;
    }

    public void setOrigPrice(double origPrice) {
        this.origPrice = origPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        if (origin.equals(destination)) {
            throw new IllegalArgumentException("The origin and destination are the same, this is not allowed.");
        } else {
            this.origin = origin;
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (origin.equals(destination)) {
            throw new IllegalArgumentException("The origin and destination are the same, this is not allowed.");
        } else {
            this.destination = destination;
        }
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public boolean bookASeat() {
        if (this.seatsLeft > 0) {
            seatsLeft--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String r = "Flight#: " + this.flightnum + ", " + this.origin + " to " + this.destination + ", " + this.depTime + ", Original Price: $" + this.origPrice;
        return r;
    }

}
