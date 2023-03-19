package coe528lab4;

import java.util.*;
import java.io.*;

/**
 *
 * @author Vikram Prashar
 */
public class Record {

    private String filename;
    private static Record instance;
    private FileReader fr;
    private FileWriter fw;

    private Record(String n) {
        filename = n;
        try {
            fr = new FileReader(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Record getinstance(String n) {
        if (instance == null) {
            instance = new Record(n);
        }
        return instance;
    }

    //Reads and prints the contents of the associated file to the standard output. 
    public void read() {
        try {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Apppends the specified message, msg, to the associated file. 
    public void write(String msg) {
        try {
            fw = new FileWriter(filename, true);
            fw.write(msg);
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("record.txt");
        f.createNewFile();
        Record r = Record.getinstance("record.txt");
        r.write("Hello-1\n");
        r.write("Hello-2\n");
        System.out.println("Currently the file record.txt contains the following lines");
        r.read();

    }

}
