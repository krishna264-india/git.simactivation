public class CircularQueue{
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int end = 0;
    protected int front = 0;
    private int size = 0;
       
    public boolean isFull() {
        return size == data.length; // ptr is at last index
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(int item){
        if(isFull()){
              return false;
        }
        data[end++]=item;
        end=end%data.length;
        siz++;
        return true;
    }
    public int pop()throws Exception{
        if(isEmpty()){
             throw new Exception ("Queue is empty!");
        }
        int removed=data[front++];
        front%=data.length;
        size--;
        return removed;
    }
    public int front()throws Exception{
        if(isEmpty()){
            throw new Exception ("queue is empty!");
        }
        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.print("Empty");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i]+"->")
            i++;
            i=i%data.length;


        }while(i!=end);
        System.out.println("End");
    }
}