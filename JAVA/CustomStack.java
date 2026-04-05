package StackPrograms;


public class CustomStack {

    protected int [] data;
    public static final int DEFAULT_SIZE=10;

    int ptr=-1;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        this.data=new int[size];

    }
       public boolean push(int iteam){
        if(isfull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr]=iteam;
        return true;

       }
       public int pop() throws SatckException{
        if(isEmpty()){
            throw new SatckException("Cannot pop from an empty stack!!");
        }
        int removed=data[ptr];
        ptr--;
        return removed;
       }
       public int peek() throws SatckException{
        if(isEmpty()){
            throw new SatckException("Cannot peek from an empty stack!!")
        }
        return  data[ptr];
       }
       public boolean isfull(){
        return ptr== data.length-1;
       }
       public boolean isEmpty(){
        return ptr==-1;
       }
    
}
