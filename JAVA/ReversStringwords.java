import java.util.Arrays;
public class ReversStringwords {
    public static void main(String[] args){
        String string="This is the my kingdom";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println(reverse);
       reverseStringByWords(string);

        String[] str="I want java developer".split("");
        String ans=" ";
        for(int i=str.length -1;i>=0;i--){
             ans+=str[i]+"";
        }
        System.out.println(ans.substring(0,ans.length()));
        // String[] str1=str.split(" ");
        // StringBuilder builder=new StringBuilder();
        // for(int i=str1.length -1;i>0;i--){
        //     builder.append(str1[i]).append("");

        // }
        // System.out.println(str1.toString().trim());

        String str1="abcdcba";
        System.out.println(isPalindrome(str1));
    }
    static boolean isPalindrome(String str1){

        for(int i=0;i<=str1.length()/2;i++){
            int start=str1.charAt(i);
            int end=str1.charAt(str1.length()-1-i);
            if(start<end){
               return false;
            }

        }
        return true;

    }
    //o/p:- Reverse words: kingdom my the is This
    public static void reverseStringByWords(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = string.split(" ");
    
        for (int j = words.length-1; j >= 0; j--) {
            stringBuilder.append(words[j]).append(' ');
        }
        System.out.println("Reverse words: " + stringBuilder);
    }
    String input="abcd";
    String an=nextChar(input);
    System.out.println(an);

    public static String nextChar(int input){

        int res="";
        for(char c:input.toCharArray()){
            if(c=='z'){
              res+='a';
              if(c=='Z'){
                res+='A';
              }else{
                res+=(char)(c+1);
              }
            }else{
                res+=c;
            }

        }
        return res;

    }
}

