import java.util.Scanner;

public class Roman {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
         System.out.println("Enter a number");
         int number=scanner.nextInt();
         if(number<1 || number>3999){
            System.out.println("Number out of range. Please enter a number between 1 and 3999.");
        } else {
            String romanNumeral = intToRoman(number);
            System.out.println("Roman numeral: " + romanNumeral);
        }

        scanner.close();
         }

    static String intToRoman(int number){
        StringBuilder roman = new StringBuilder();
        
        int[] values={1000,900,500,400,100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i=0;i<values.length;i++){
            while(number>=values[i]){
                roman.append(romanSymbols[i]);
                number-=values[i];
            }   
        }
        return roman.toString();

    }
}
