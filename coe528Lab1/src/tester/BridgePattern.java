
import java.util.ArrayList;

public class BridgePattern {

    public static void main(String[] args) {
        Abstraction a1 = new UserProfile(new EncryptionOne(), "john", 5);
        a1.print();
        String[] arr = {"hello", "world"};
        Abstraction a2 = new Message(new EncryptionOne(), arr);
        a2.print();

        a1.setEncryption(new EncryptionTwo());
        a1.print();
        a2.setEncryption(new EncryptionTwo());
        a2.print();
    }
}

abstract class Abstraction {

    public String encrypt(String s) {
        return "";
    }

    public int encrypt(int i) {
        return 0;
    }

    public abstract void print();

    abstract public void setEncryption(Implementation i);
}

class UserProfile extends Abstraction {

    private Implementation implement = null;
    String username;
    int id;

    UserProfile(Implementation i, String u, int id) {
        this.implement = i;
        this.username = u;
        this.id = id;
    }

    @Override
    public void setEncryption(Implementation i) {
        this.implement = i;
    }

    @Override
    public void print() {
        System.out.println(implement.encrypt(username) + " " + implement.encrypt(id));
    }
}

class Message extends Abstraction {

    private Implementation implement = null;
    String[] arr;

    Message(EncryptionOne i, String[] arr) {
        this.implement = i;
        this.arr = arr;
    }

    @Override
    public void setEncryption(Implementation i) {
        this.implement = i;
    }

    @Override
    public void print() {
        for (String s : arr) {
            System.out.print(implement.encrypt(s) + " ");
        }
        System.out.println();
    }
}

abstract class Implementation {

    public abstract String encrypt(String s);

    public abstract int encrypt(int i);
}

class EncryptionOne extends Implementation {

    @Override
    public String encrypt(String s) {
        String temp = "";
        for (int i = s.length() - 1; i > -1; i--) {
            temp+= s.charAt(i);
        }
        return temp;
    }

    @Override
    public int encrypt(int i) {
        return i * 2 + 1;
    }
}

class EncryptionTwo extends Implementation {

    @Override
    public String encrypt(String s) {
        return "2" + s + "2";
    }

    @Override
    public int encrypt(int i) {
        return 3 * i + 2;
    }
}
