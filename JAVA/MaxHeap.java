public class MaxHeap {
    
    private ArrayList<Integer> heap;
    public MaxHeap(){
        heap=new ArrayList<>();
    }
    private int parent(int i){
         return (i-1)/2;
    }
    private int left(int i){
        return 2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }
    private void swap(int i,int j){
        int temp=heap.get(i);
        heap.set(i,heap.get(i));
        heap.set(j,temp);
    }
    public static void insert(int value){
        heap.add(value);// 
        int currentindex=heap.size()-1;// last index of the heap
        while(currentindex>0 && heap.get(currentindex)> heap.get(parent(currentindex))){
            swap(currentindex,parent(currentindex));
            currentindex=parent(currentindex);
        }
        public static int extractMax(){
            if(heap.isEmpty()){
                return -1;
            }
            int max=heap.get(0);
            int currentindex=0;
            while(true){
                 int leftindex=left(currentindex);
                 int rightindex=right(currentindex);
                 int largest= currentindex;
                 if( leftindex<heap.size() && heap.get(leftindex)>heap.get(largest)){
                    largest=leftindex;
                 }
                 if( rightindex<heap.size() && heap.get(rightindex)>heap.get(largest)){
                     largest=rightindex;
                 }
                 if(largest== currentindex){
                        break;
                 }
                  swap(currentindex,largest);
                  currentindex= largest;
            }
        }
        return max;
    }
    public static void main(String[] args){
        heap.insert(10);
        heap.insert(9);
        heap.insert(13);
        heap.insert(20);
        heap.insert(15);
        heap.insert(8);

        System.out.println(heap.extractMax());
    }
}
