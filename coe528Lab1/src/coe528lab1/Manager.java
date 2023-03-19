package coe528lab1;

import java.util.*;

/**
 *
 * @author Vikram Prashar
 */
public class Manager {

    private ArrayList<Flight> Flights = new ArrayList<Flight>();
    private ArrayList<Ticket> Tickets = new ArrayList<Ticket>();
    Scanner in = new Scanner(System.in);

    public void createFlights() {
        System.out.println("How many flights would you like to enter in?");
        int numoff = in.nextInt();
        for (int i = 0; i < numoff; i++) {
            System.out.println("Enter flight information in this order: Flight Number, capacity, Original Price, Origin, Destination and finally Departure Time.\nPlease have a space between the variables ");
            int flightnum = in.nextInt();
            int capacity = in.nextInt();
            double OrigPrice = in.nextDouble();
            String origin = in.next();
            String destination = in.next();
            String depTime = in.next() + " " + in.next();
            Flight f = new Flight(flightnum, capacity, OrigPrice, origin, destination, depTime);
            Flights.add(f);
        }
    }

    public void displayAvailableFlights(String origin, String destination) {
        for (int i = 0; i < Flights.size(); i++) {
            if ((origin.equals(Flights.get(i).getOrigin())) && (destination.equals(Flights.get(i).getDestination()))) {
                if (Flights.get(i).getSeatsLeft() != 0) {
                    System.out.println(Flights.get(i));
                }
            }
        }
    }

    public Flight getFlight(int flightNumber) {
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getFlightnum() == flightNumber) {
                return Flights.get(i);
            }
        }
        return null;

    }

    public void bookSeat(int flightNumber, Passenger p) {
        double postp;
        Flight f = null;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getFlightnum() == flightNumber) {
                boolean check = Flights.get(i).bookASeat();
                if (check) {
                    f = Flights.get(i);
                }

            }
        }
        postp = p.applyDiscount(f.getOrigPrice());
        Ticket t = new Ticket(p, f, postp);
        Tickets.add(t);
        System.out.println("Ticket has been issued for: " + p.getName() + ". For flight number: " + flightNumber);
    }

    public static void main(String[] args) {        
        Member m1 = new Member(6, 25, "Vikram");
        Member m2 = new Member(2, 45, "Tihamah");
        NonMember m3 = new NonMember(66, "Anika");
        NonMember m4 = new NonMember(25, "Numair");
        Manager main = new Manager();
        main.createFlights();
        /**
         * To show that my methods work I have made some sample data to show the
         * functionality for all the methods in the Manager class. It is not necessary 
         * to use this data. Since the lab manual didn't have rules for exceptions 
         * regarding user data other than the origin and destination, please use this
         * format when entering any
         * Flight1: 100 1000 2000 Toronto Delhi 1/1/2020 9:00pm 
         * Flight2: 200 1500 1750 Delhi Berlin 2/14/2022 2:00am
         */

        System.out.println("\nThe following should print out the first flight:");
        main.displayAvailableFlights(main.Flights.get(0).getOrigin(), main.Flights.get(0).getDestination());

        System.out.println("\nThis should output second flight:");
        System.out.println(main.getFlight(main.Flights.get(1).getFlightnum()));

        System.out.println("\nThis should output the name and flight number for the ticket that has been issued:");
        main.bookSeat(main.Flights.get(0).getFlightnum(), m1);
        main.bookSeat(main.Flights.get(0).getFlightnum(), m2);
        main.bookSeat(main.Flights.get(0).getFlightnum(), m3);
        main.bookSeat(main.Flights.get(0).getFlightnum(), m4);
        //This code doesn't show functionality for Manager but rather just shows the details 
        //of the tickets that have been issued to show that the discount has been applied correctly.
        System.out.println("\nThis should output ticket details to show the correct discount being applied:");
        System.out.println(main.Tickets.get(0));
        System.out.println(main.Tickets.get(1));
        System.out.println(main.Tickets.get(2));
        System.out.println(main.Tickets.get(3));
    }
}
