package ArrayProblems;

import java.util.Stack;

public class StackProblems {
    public static void main(String[] args) {
        String num="1432219";
        int k=3;
        System.out.println(smallestNumberAfterKRemovals(num,k)); // Expected output: "1219"
        
    }
    static String smallestNumberAfterKRemovals (String num, int k){
        Stack<Character> stack=new Stack<>();
        for(char digit:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                stack.pop();
                k--;// remove the larger digit to make the number smaller
            }
            // add the current digit to the stack
            stack.push(digit);
        }
    // if k is still greater than 0, remove the remaining digits from the end
        while(k>0){
            stack.pop();
            k--;
        }
        // build the resulting number from the stack
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        // remove leading zeros
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length() ==0 ? "0" : sb.toString();
    }
    
}
