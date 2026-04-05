/*Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent. 
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/
import java.util.*;
public class LettersCOPN {
    public static void main(String[] args){
        phoneNum(" ","12");
        System.out.println(pad(" ","8"));
       // int number=1234;
     //   System.out.println(NumbersToLetters(number));

    }
    static void phoneNum(String p,String up){
        if(up.isEmpty()){
          System.out.println(p);
          return;
        }
        int digits=up.charAt(0) -'0';// convert char to int
        for(int i=(digits-1)*3; i<digits*3; i++){
               char ch=(char)('a'+i);
               phoneNum(p+ch,up.substring(1));
        }

    }
    static ArrayList<String> pad(String p,String up){
        if(up.isEmpty()){
          ArrayList<String> list=new ArrayList<>();
          list.add(p);
          return list;
        }
        int digits=up.charAt(0) -'0';
        ArrayList<String> list =new ArrayList<>();
        for(int i=(digits-1)*3; i<digits*3; i++){
               char ch=(char)('a'+i);
               list.addAll(pad(p+ch,up.substring(1)));
        }
           return list;
    }
    //leetcode question :17
   static List<String> letterCombinations(String digits){
    if(digits.isEmpty()){
        return new ArrayList<>();
    }
    List<String> list=new ArrayList<>();
    list.add("");
    //sotre the letters in array
    String[] digitToLetters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // Iterate over each digit in the input string.
    for(char digit:digits.toCharArray()){
            //create dummy list
            List<String> ans=new ArrayList<>();
            for(String combination:list)
                for(char letters:digitToLetters[digit-'0'].toCharArray())
                    ans.add(combination+letters);
                    list=ans;
    }
            return list; 
}

//master card questions.

public static String   NumbersToLetters(int number){
    String[] letters={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","nine"};
    //convert the numbers  to string
    String numbersStr=Integer.toString(number);
    //holding the result
    StringBuilder builder=new StringBuilder();
    //iterate over each digit in number
    for(int i=0;i<numbersStr.length();i++){
        //add the letters to the result
        char digits=numbersStr.charAt(i);
        // convert the digit to letter 
        int digit=digits-'0';

        builder.append(letters[digit]).append(",");
    }
    return builder.toString().substring(0,builder.length()-1);
}

}
