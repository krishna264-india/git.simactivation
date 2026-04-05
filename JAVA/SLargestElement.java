import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
public class SLargestElement {
    public static void main(String[] args){
       // int[] arr={11,23,28,30,40,50,60,70};
       int[] arr={2,5,0,1,1,0,1,3,1,0,0};
       int ans=sortZeroAndOnes(arr);
        int max=arr[0];
        int secondLargetst=arr[0];
        List<Integer> list=Arrays.asList(1,10,12,34,1,2,98);
        Optional<Integer> secondMax=list.stream().
        sorted(Comparator.reverseOrder()).
        distinct().
        limit(2).skip(1).findFirst(). orElse(null);

        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                secondLargetst=max;
                max=arr[i];
            }
            else if( arr[i]>secondLargetst && arr[i]!=max){
                secondLargetst=arr[i];
            }
        }
        System.out.println("Second largest elements is: "+ secondLargetst);
    }
    public void sortZeroAndOnes(int[] arr){
        int i=0, j=arr.length-1;
        while(i<j){
            while(i<j && arr[i]==0){
                i++;// move the left pointer to the right until we find a 1
            }
            while(i<j && arr[j]==1){
                j--;// move the right pointer to the left until we find a 0
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    
}
