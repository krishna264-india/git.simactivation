/**
 * LinearSearch
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] arr={5,2,20,34,45,89,80};
        int target=80;
        // System.out.println(linearSearch(arr,target,2,5));
         System.out.println(linearSearch(arr,target));
    }
    static int linearSearch(int[] arr,int target){
        // if(arr.length==0){
        //     return-1;

        // }
        //for(int i=start;i<end;i++){
            for(int i=0;i<arr.length;i++){
            //int element=arr[i];
            if(arr[i]==target){
                return i;

            }

        }
        return-1;

    }
}