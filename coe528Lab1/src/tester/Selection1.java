/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

/**
 *
 * @author Vikram Prashar
 */
public class Selection1 {

    public static void main(String[] args) {
        A a1 = new B("java");
        System.out.println(a1.x());
        System.out.println(a1.y());
        a1.z();
    }
}

abstract class A {

    private String str = "";

    public A() {
        System.out.println("A()");
    }

    public A(String s) {
        System.out.println("A(" + s + ")");
        str = s;
    }

    public String x() {
        z();
        System.out.println("A.x()");
        return str + y();
    }

    public int y() {
        System.out.println("A.y()");
        return 1;
    }

    public abstract void z();
}

class B extends A {

    private C ins;

    public B() {
        System.out.println("B()");
        ins = new C();
    }

    public B(String s) {
        System.out.println("B(" + s + ")");
        ins = new C(s);
    }

    public String x() {
        String s = super.x();
        return (s + ins.m1());
    }

    public int y() {
        return ins.m2();
    }

    public void z() {
        ins.m3();
        System.out.println("B.z()");
    }

}

class C {

    private String str = "";

    public C() {
    }

    public C(String s) {
        str = s;
    }

    public String m1() {
        return str + "C";
    }

    public int m2() {
        return 2;
    }

    public void m3() {
        System.out.println("C.z()");
    }

}
