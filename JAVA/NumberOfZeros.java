public class NumberOfZeros {
    public static void main(String[] args){
        int n=20023;
        System.out.println(zeros(n)); 

    }
    static int zeros(int n){
        return helper(n,c);

    }
     static int helper(int n, int c){
        if(n==0){
            return c;
        }
        int rem=n%10;
        if(rem==0){
          return helper(n, c+1);
        }
        return helper(n,c);

    }
}
