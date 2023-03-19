package coe528lab2;

/**
 *
 * @author Vikram Prashar
 */
public class ProceduralAbstraction {

    public static int reverseFactorial(int x) {
        boolean check = true;
        int fact = 1;
        int upper = 1;
        do {
            for (int i = 1; i <= upper; i++) {
                fact = fact * i;
            }
            if (fact >= x) {
                check = false;
            } else {
                upper++;
                fact = 1;
            }
        } while (check);
        return upper;
    }

    public static boolean isMatrixNice(int[][] arr) {
        int checker = 0;
        for (int i = 0; i < arr.length; i++) {
            checker += arr[0][i];
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int c = 0; c < arr.length; c++) {
                sum += arr[i][c];
            }
            if (sum != checker) {
                return false;
            }
            sum = 0;

            for (int c = 0; c < arr.length; c++) {
                sum += arr[c][i];
            }
            if (sum != checker) {
                return false;
            }
            sum = 0;
        }
        
        
        for (int c = 0; c < arr.length; c++) {
            sum += arr[c][c];
        }
        if (sum != checker) {
            return false;
        }
        
        
        sum=0;
        int temp=arr.length-1;
        for (int r = 0; r < arr.length; r++) {
            sum+=arr[r][temp];
            temp--;
        }
        
        if(sum!=checker){
            System.out.println("4");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        
        
        
        
    }

}
