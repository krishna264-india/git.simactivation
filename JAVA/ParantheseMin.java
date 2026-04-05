import java.util.Stack;

public class ParantheseMin {
    public static void main(String[] args){
        String test1 = "())";          // Needs 1 '('
        String test2 = "(((";          // Needs 3 ')'
        String test3 = "()((";         // Needs 2 ')'
        String test4 = "()))((";       // Needs 2 '(' and 1 ')'
        String test5 = "";             // Already valid

        System.out.println("Minimum parentheses to add for \"" + test1 + "\": " + minAddToMakeValid(test1)); // 1
        System.out.println("Minimum parentheses to add for \"" + test2 + "\": " + minAddToMakeValid(test2)); // 3
        System.out.println("Minimum parentheses to add for \"" + test3 + "\": " + minAddToMakeValid(test3)); // 2
        System.out.println("Minimum parentheses to add for \"" + test4 + "\": " + minAddToMakeValid(test4)); // 3
        System.out.println("Minimum parentheses to add for \"" + test5 + "\": " + minAddToMakeValid(test5)); // 0

    }
    public int minAddToMakeValid(String s) {
         Stack<Character> stack=new Stack<>();
         for(char ch:s.toCharArray()){
            if(ch==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }

            }else{
                stack.push(ch);
            }

         }
         return stack.size();
   }
    public int minAddToMakeValid(String s) {
        int opencount=0;
        int closecount=0;
        for(char ch:s.toCharArray()){
             if(ch=='('){
                opencount++;

             }else if(ch==')'){
                if(opencount>0){
                    opencount--;

                }
                else{
                closecount++;
             }
             }

        }
        return opencount+closecount;
    }
}
