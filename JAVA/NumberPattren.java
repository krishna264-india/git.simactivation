
import java.util.Scanner;
public class NumberPattren {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
     System.out.println("Enter a number");
        int n=scanner.nextInt();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i || j==n-i-1){
                    System.out.print(n-i);
                }else{
                    System.out.print(n);
                }
            }
            System.out.println ();

        }
          scanner.close();

    }
}
