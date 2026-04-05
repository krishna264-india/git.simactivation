package StackPrograms;

public class MainStack {
    public static void main(String []args){
        CustomStack stack=new CustomStack(5);
        stack.push(10);
        stack.push(8);
        stack.push(6);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
