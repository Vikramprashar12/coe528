
import java.util.*;

public class QueueofDistinctStrings {
    // Overview: QueueOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// FIFO (First-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
// AB(c) = an abstract queue d
// where d.front = items.get(0)
// ,d.end = items.get(items.size()-1)
// d.collection = items
//
// The rep invariant is:
// b) Write the rep invariant here
// RI(c) = false if two strings in items are the same, a string is null and items.size()<0 .
//         true otherwise.
//
//
//the rep

    private ArrayList<String> items;
// constructor

    public QueueofDistinctStrings() {
// EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
// MODIFIES: this
// EFFECTS: Appends the element at the end of the queue
// if the element is not in the queue, otherwise
// does nothing.

    public void enqueue(String element) throws Exception {
        if (element == null) {
            throw new Exception();
        }
        if (false == items.contains(element)) {
            items.add(element);
        }

    }

    public String dequeue() throws Exception {
// MODIFIES: this
// EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0) {
            throw new Exception();
        }
        return items.remove(0);
    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here
        String checker = "";
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == null) {
                return false;
            }
            checker = items.get(i);
            for (int c = 0; c < items.size(); c++) {
                if (checker.equals(items.get(c))) {
                    return false;
                }
            }
        }
        if (items.size() < 0) {
            return false;
        }
        return true;
    }

    public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// queue, the front element and the end element.
// Implements the abstraction function.
// d) Write the code for the toString() here
        String r = "The front of the queue is: " + items.get(0) + ". The end of the queue is: " + items.get(items.size() - 1) + ".";
        for (int i = 0; i < items.size(); i++) {
            r += "\nIndex " + i + ": "+items.get(i);
        }
        return r;
    }
}
