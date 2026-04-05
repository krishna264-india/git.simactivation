import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumber {
    public static void main(String[] args) {
        int[] array={2,3,3,3,5,7,8,9,1};
        Set<Integer> set=Arrays.stream(array)
                        .boxed()
                        .collect(Collectors.toSet());
            List<Integer> list=IntStream.rangeClosed(1,9)
                               .filter(i->set.contains(i))
                               .boxed()
                               .toList();
                System.out.println(list);
    }
    public static int findMissingNumber(int[] arr){
        int n=arr.length+1;
        int j=0;
        for(int i=1;i<=n;i++){
            if(j<arr.length && arr[j]==i){
                j++;
            }else{
                return i;
            }
        }
    //     int expectedSum=n*(n+1)/2;
    //    for(int num:arr){
    //     expectedSum-=num;
    //    }
    //      return expectedSum;
         return -1;
    }
}
