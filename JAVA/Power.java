import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int power=power(a,b);
        System.out.println(power);

    }
    public static int power(int a,int b){
         int power=1;
         for(int i=1;i<=b;i++){
            power=power*b;
         }
         return power;
    }
    
}
