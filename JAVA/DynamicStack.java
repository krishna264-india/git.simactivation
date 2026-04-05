package StackPrograms;

public class DynamicStack extends CustomStack {
  
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);

    }
    @override
    public boolean push(int item){
        if(this.isfull()){
            //double the array...
            int[] temp=new int[data.length*2];
             // copy all previous items in new data
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            temp=data;
        }
        // at this point we know that array is not full
        // insert item
        return super.push(item);

    }

    
}
