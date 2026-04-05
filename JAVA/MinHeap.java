import java.util.*;
import java.util.Map;

public class MinHeap {
   private List<Integer> heap;

   public MinHeap(){
     heap=new ArrayList<>();
   }
    // Returns the index of the parent node
    private int parent(int i){
        return (i-1)/2;
    }
     // Returns the index of the left child node
    private int leftChild(int i){
        return 2*i+1;
    }
    // Returns the index of the right child node
    private int rightChild(int i){
        return 2*i+2;
    }
    private void swap(int i,int j){
        int temp=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    public static  void insert(int value){
        // Add the new value at the end of the heap
        heap.add(value);
        // Get the index of the newly added value
        int currentindex=heap.size()-1;
        // Bubble up to restore heap property
        while(currentindex > 0 && heap.get(currentindex)< heap.get(parent(currentindex))){
            swap(currentindex,parent(currentindex));// Swap with parent if current value is less 
            currentindex=parent(currentindex); // Move up to the parent index

        }
        public static int minExtract(){
            if(heap.isEmpty()){
                return -1;
            }
            // Store the root node value
            int min=heap.get(0);
             // Remove the last element
             int lastElement=heap.remove(heap.size()-1);

             // Bubble down to restore heap property
             int currentindex=0;
             while(true){
                int left=leftChild(currentindex);
                int right=rightChild(currentindex);
                int smallest=currentindex;
                if(left<heap.size() && heap.get(left)< heap.get(smallest) ){
                    smallest=left;
                }
                if(right<heap.size() && heap.get(right)<heap.get(smallest)){
                    smallest=right;

                }
                if(smallest==currentindex){
                    // Heap property is restored
                     break;
                }
                //Swap with the smallest child
                swap(currentindex,smallest);
                
                currentindex=smallest;

             }

        }
        return min;
    } 
    public static boolean isEmpty(){
          return heap.isEmpty();
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Insert values into the min heap
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(25);
        System.out.println(minHeap.minExtract());
        System.out.println(minHeap.minExtract());

    }


}
