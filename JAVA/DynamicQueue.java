package StackPrograms;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue(){
        super();
    }
    public DynamicQueue(int size){
        super(size);
           
    }

    public boolean add(int item){
        if(this.isFull()){
              int[] temp=new int[data.length *2];
              for(int i=0;i<data.length;i++){
                temp[i]=data[(front+i)%data.length];

              }
              front=0;
              end=data.length;
              temp=data;
        }
        return super.add(item);

    }
    
}
