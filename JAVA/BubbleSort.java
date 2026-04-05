import java.util.Arrays;

import org.w3c.dom.Node;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr={5,3,2,4,1};
        sort(arr);
          System.out.println(Arrays.toString(arr));
    }
    /*
     * Bubble Sort Algorithm
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Stable Sorting Algorithm
     * In-Place Sorting Algorithm
     */
    static void sort(int[] arr){
        // Bubble Sort Algorithm
        for(int i=0;i<arr.length;i++){ 
            for(int j=1;j<arr.length-i;j++){
                  if(arr[j]<arr[j-1]){
                       int temp=arr[j];
                       arr[j]=arr[j-1];
                       arr[j-1]=temp;
                  }
            }
        }
    }
}
