public class Recursion {
    public static void main(String[] args){
       // print(1);
        int n=7;
        System.out.println(fib(n));
    }
    static int fib(int n){
        if(n<2){
          return n;
        }
        return fib(n-1)+fib(n-2);

    }
    static void print(int n){
        if(n==20){
           System.out.println(20);
           return;
        }
        System.out.println(n);
        print(n-1);

    }
    static void fun(int n){
        

    }
    
}
