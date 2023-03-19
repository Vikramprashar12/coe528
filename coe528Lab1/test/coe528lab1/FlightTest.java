package coe528lab1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vikram Prashar
 */
public class FlightTest {

    public FlightTest() {
    }
    
    Flight x = new Flight(1080, 200, 500, "Toronto", "Delhi", "1/1/2022 8:00pm");

    @Test
    public void testConstructor() {
        int e1 = 1080;
        int a1 = x.flightnum;
        assertEquals(e1, a1);
        int e2 = 200;
        int a2 = x.capacity;
        int seats = x.seatsLeft;
        assertEquals(e2, a2, seats);
        double e3 = 500;
        double a3 = x.origPrice;
        assertEquals(e3, a3, 0.00001);
        String e4 = "Toronto";
        String a4 = x.origin;
        assertEquals(e4, a4);
        String e5 = "Delhi";
        String a5 = x.destination;
        assertEquals(e5, a5);
        String e6 = "1/1/2022 8:00pm";
        String a6 = x.depTime;
        assertEquals(e6, a6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        Flight a = new Flight(1080, 200, 500, "Toronto", "Toronto", "1/1/2022 8:00pm");
    }

    @Test
    public void testToString() {
        String exp = "Flight#: 1080, Toronto to Delhi, 1/1/2022 8:00pm, Original Price: $500.0";
        String actual = x.toString();
        assertEquals(exp, actual);
    }

    @Test
    public void testGetFlightnum() {
        int exp = 1080;
        int actual = x.flightnum;
        assertEquals(exp, actual);
    }

    @Test
    public void testSetFlightnum() {
        x.setFlightnum(1920);
        int exp = 1920;
        int actual = x.flightnum;
        assertEquals(exp, actual);
    }

    @Test
    public void testGetCapacity() {
        int exp = 200;
        int actual = x.capacity;
        assertEquals(exp, actual);

    }

    @Test
    public void testSetCapacity() {
        x.setCapacity(300);
        int exp = 300;
        int actual = x.capacity;
        assertEquals(exp, actual);
    }

    @Test
    public void testGetSeatsLeft() {
        int exp = 200;
        int actual = x.seatsLeft;
        assertEquals(exp, actual);
    }

    @Test
    public void testSetSeatsLeft() {
        x.setSeatsLeft(100);
        int exp=100;
        int actual=x.seatsLeft;
        assertEquals(exp,actual);
                
    }

    @Test
    public void testGetOrigPrice() {
        double exp = 500.0;
        double actual = x.origPrice;
        assertEquals(exp, actual, 0.00001);
    }

    @Test
    public void testSetOrigPrice() {
        x.setOrigPrice(1000.0);
        double exp = 1000.0;
        double actual = x.origPrice;
        assertEquals(exp, actual, 0.00001);
    }

    @Test
    public void testGetOrigin() {
        String exp = "Toronto";
        String actual = x.origin;
        assertEquals(exp, actual);
    }

    @Test
    public void testSetOrigin() {
        x.setOrigin("Berlin");
        String exp = "Berlin";
        String actual = x.origin;
        assertEquals(exp, actual);
    }

    @Test
    public void testGetDestination() {
        String exp = "Delhi";
        String actual = x.destination;
        assertEquals(exp, actual);
    }

    @Test
    public void testSetDestination() {
        x.setDestination("Berlin");
        String exp = "Berlin";
        String actual = x.destination;
        assertEquals(exp, actual);
    }

    @Test
    public void testGetDepTime() {
        String exp = "1/1/2022 8:00pm";
        String actual = x.depTime;
        assertEquals(exp, actual);
    }

    @Test
    public void testSetDepTime() {
        x.setDepTime("1/1/2022 9:00pm");
        String exp = "1/1/2022 9:00pm";
        String actual = x.depTime;
        assertEquals(exp, actual);
    }

    @Test
    public void testBookASeat() {
        int temp = x.seatsLeft;
        x.bookASeat();
        assertEquals(temp - 1, x.seatsLeft);
        x.setSeatsLeft(0);
        x.bookASeat();
        assertEquals(0, x.seatsLeft);
    }

}
