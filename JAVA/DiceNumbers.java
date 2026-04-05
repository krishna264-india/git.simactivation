import java.util.ArrayList;
import java.util.List;

public class DiceNumbers {
    public static void main(String[] args){
        // dice(" ",4);
         System.out.println(letterCombinations1("23"));
    }
    static void dice(String p,int target){
        if(target==0){
           System.out.println(p);
           return;
        }
        for(int i=1;i<=6 && i<=target;i++){
            dice(p+i,target-i);
        }

    }
    /*
     * This function generates all possible letter combinations
     * for a given string of digits.
     * Each digit maps to a set of letters similar to a telephone keypad.
     */
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list=new ArrayList<>();
        // A result list to store the final combinations.
        if(digits.isEmpty()){
            // Add an empty string as an initial value to start the combinations.
            list.add("");
           return list;
        }
        

         String[] digitoLetters={"","","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
         // Iterate over each digit in the input string.
         for(char digit:digits.toCharArray()){
            // Get the corresponding letters for the current digit.
            String letters=digitoLetters[digit-'2'];
            // Create a new list to store the combinations for the current digit.
        ArrayList<String> list1=new ArrayList<>();
          for(String combinatio:list){
            for(char letter:letters.toCharArray()){
                  list1.add(combinatio+letter);
            }

          }
             list= list1;
    }
    return list;
    }

    static List<String> letterCombinations1(String digits){
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> list=new ArrayList<>();
        list.add("");
        String[] digitToLetters={"","","abc","def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
        // Iterate over each digit in the input string.
        for(char digit:digits.toCharArray()){
                List<String> ans=new ArrayList<>();
                for(String combination:list)
                    for(char letters:digitToLetters[digit-'0'].toCharArray())
                        ans.add(combination+letters);
                        list=ans;
        }

                return list;
    }
       
}

