import java.util.Arrays;
public class MergSort {
    public static  void main(String[] args){
        int[] arr={9,8,6,4,5,2,3,1};
        // arr=mergeSort(arr);
        // System.out.println(Arrays.toString(arr));

        System.out.println("Unsorted array:");
        printArray(arr);

          mergeSorted(arr,0,arr.length-1);
          
        System.out.println("\nSorted array:");
        printArray(arr);
        
         
         
    }

    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
       int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));
       int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length-1));

        return merge(left,right);
    }
    static int[] merge(int[] first,int[] second){
        int[] mix=new int[first.length+second.length];
        int i=0,j=0,k=0;

        while(i < first.length && j < second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;

            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;

        }
        while(i<first.length){
             mix[k]=first[i];
             i++;
             k++;
        }
        while(j<second.length){
          mix[k]=second[j];
          j++;
          k++;
        }
        return mix;

    }
    static void mergeSorted(int[] arr,int left,int right){
         int mid=(left+right)/2;
         mergeSorted(arr,left,mid);
         mergeSorted(arr,mid+1,right);

         merged(arr,left,mid,right);
    }

    static void merged(int[] arr,int left,int mid,int right){
        // Find sizes of two subarrays to be merged
        int m=mid-left+1;
        int n=right-mid;
           // Create temp arrays
        int[] first=new int[m];// left half
        int[] sec=new int[n];// right half
       //data add to the dupicate arrays
        for(int i=0;i<m;i++){
            first[i]=arr[left+i];
        }
        for(int j=0;j<n;j++){
            sec[j]=arr[mid+1+j];
        }
        // 
        int i=0;
        int j=0;
        int k=left;
        while(i<m && j<n){// merge the two sorted array
              if(first[i]<=sec[j]){// if left half is smaller 
                arr[k]=first[i];
                i++;
              }
              else{
                arr[k]=sec[j];
                j++;
              }
              k++;
        }
        while(i<m){
            arr[k]=first[i];
            i++;
            k++;
        }
        while(j<n){
           arr[k]=sec[j];
           j++;
           k++;
        }
           
    }
    // Function to print an array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
