import java.util.Arrays;
/*
    * Insertion Sort Algorithm: 
why is it used: it is used to sort a list of elements in ascending or descending order.
how it works: It works by dividing the list into a sorted and an unsorted part.
It repeatedly takes the first element from the unsorted part and inserts it into the correct position in the sorted part.
Time Complexity: O(n^2) in the worst and average case, O(n) in the best case (when the array is already sorted).
Space Complexity: O(1) (in-place sorting algorithm).
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] arr={5,4,3,1,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void insertionSort(int[] arr){
           for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j] < arr[j-1]){
                   swap(arr,j,j-1);
                }
                else{
                    break;
            }
           }
    }
}
    static  void swap(int[] arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    
}
