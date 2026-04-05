import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddSpecialSym {
    public static void main(String[] args) {
        String str="123456789";
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<str.length();i++){
            builder.append(str.charAt(i));
        // add symbol after every 3 characters, but not at the end of the string
            if((i+1)%3==0 && i!=str.length()-1){
                builder.append("-");
            }
        }
        System.out.println(builder.toString());

        // using other approach
        List<Integer> numbers = Arrays.asList(5, 3, 9, 3, 7, 5, 1);
        String specialSymbol = "@";

        List<String> result = new ArrayList<>();
        int count = 0;

        for (Integer num : numbers) {
            result.add(String.valueOf(num));
            count++;
            if (count % 3 == 0) {
                result.add(specialSymbol); // add symbol after every 3 numbers
            }
        }

        String finalResult = String.join("-", result);
        System.out.println(finalResult);
    }
}
