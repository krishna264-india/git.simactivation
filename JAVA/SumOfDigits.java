/*
 * By using recursion
 */
public class SumOfDigits {
     public static void main(String[] args){
        int n=1432;
        int ans=sumDigits(n);
        System.out.println(ans);
        System.out.println(sumOfProd(n));

     }
     static int sumDigits(int n){
        if(n==0){
          return 0;
        }
        return (n%10)+sumDigits(n/10);

     }

     static int sumOfProd(int n){
          if(n%10==n){
            return n;
          }
          return (n%10)*sumOfProd(n/10);
     }
     public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        while(n!=1){
            int sum=0;
            while(n>0){
                int digit=n%10;
                sum+=digit*digit;
                n=n/10;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            n=sum;
        }
        return true;
    }
}
