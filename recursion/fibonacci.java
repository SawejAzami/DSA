import java.util.*;

class recursion{
    public static int fibo(int n){
       
        if(n==0||n==1){
            return n;
        }
        int num1=fibo(n-1);
        // System.out.println(num1);
        int num2=fibo(n-2);
        // System.out.println(num2);

        return num1+num2;
    }
    public static void main(String[] args){
        System.out.println(fibo(25));
    }
}