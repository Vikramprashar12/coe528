/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

public class foowhite {

    static boolean foo(int n) {
        int countf=0;
        int countw=0;
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            return true;
        } else {
            int s = n;
            int r = 0;
            while (s != 0) {
                int remainder = s % 10;
                r = r * 10 + remainder;
                s = s / 10;
                countw++;
            }
            boolean res = false;
            for (int i = 4; i <= n; i = i + 20) {
                if (n % 2 == 1) {
                    res = true;
                }
                countf++;
            }
            System.out.print("While loop:"+countw+" For loop:"+countf);
            if (((n == r) == true) && ((n <= 2 || res == true) == true)) {
                return true;
            } else {
                return false;
            }

        }
    }

    public static void main(String[] args) {
        for(int i=-1;i<40;i++){
            System.out.println("For input: "+i);
            System.out.println(" "+foo(i)+"\n");
        }
    }

}
