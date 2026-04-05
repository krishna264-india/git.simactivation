public class PrimeNumbers {
    public static void main(String[] args){
          printPrimeNumbers(0,100000);

    }
    public static void printPrimeNumbers(int start,int end){
        if(start<0){
            System.out.println("none of the number is prime");
            return;
        }
        for(int i=start;i<=end;i++){
            if(isPrime(i)){
               System.out.println(i+" ");
            }

        }

    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }

        }
        return true;

    }
    
}
