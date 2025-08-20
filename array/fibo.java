import java.util.*;

// it is solved by using the concept of DP

class fibonacci{
    public static int fibo(int n,HashMap<Integer,Integer> list){
        if(n<=1){
            return n;
        }
        if(list.containsKey(n)){
            return list.get(n);
        }
        int val=fibo(n-1,list)+fibo(n-2,list);
        list.put(n,val);
        return val;
    }

    public static void main(String...a){
        HashMap<Integer,Integer> list=new HashMap<>();
        System.out.println(fibo(7,list));
    }
}