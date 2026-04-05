import java.util.Arrays;

public class SortingTwoPointers {
    public static void main(String[] args){
          int[] arr={2,7,11,13};
          int target=9;
           Arrays.sort(arr);

           int s=0;
           int e=arr.length-1;
           while(s<e){
            int m=s+e;
            if(m==target){
                System.out.println("two numbers "+arr[s]+"and"+arr[e]);
                return;
            }else if(m<target){
                 e++;
            }else{
                s--;
            }

           }
           System.out.println("No solution found");
    }
}
