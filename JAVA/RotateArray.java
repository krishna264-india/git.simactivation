public class RotateArray {
    public static void main(String[] args){
        int[] arr= {1,2,3,4,5,6,7};
        int k=3;
        rotate(arr,n);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    static void rotate(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        int[] temp=new int[k]; 
        // Step 1: Copy the last k elements to the temporary array
        for(int i=0;i<k;i++){
            temp[i]= arr[n-k+i];// copy last k elements
        }
        // Step 2: Shift the remaining elements of the array to the right
        for(int i=n-k-1;i>=0;i--){
            arr[i]=arr[i-k];
        }
        // Step 3: Copy the elements from the temporary array to the end of the original array
        for(int i=0;i<k;i++){
            arr[i]=temp[i];
        }
    }
    static void rotateLeft( int[] arr, int k){
        int n=arr.length;
        k=k%n;
        reverse(arr,0,k-1);// revese first k element
        reverse(arr,k,n-1);// reverse  last n-k element
        reverse(arr,0,n-1);// reverse whole array 
           
    }
    static void rotateRight(int[] arr, int k){
        int n=arr.length;
        k=k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr, k,n-1);
    }
    static void reverse( int[] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
