import java.util.*;

 class Recursion {
    public static int sumOfNaturalNo(int n) {
        if (n == 1) {  
            return 1;
        }
        return n + sumOfNaturalNo(n - 1); 
    }

    public static void main(String[] args) {
        System.out.println(sumOfNaturalNo(5));
    }
}
