import java.util.*;
public class SubSet {
    public static void main(String[] args){
        int[] arr={2,3,3};
        List<List<Integer>> ans=subSetDuplicate(arr);
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }

    /*
     * []
[2]
[3]
[2, 3]
[4]
[2, 4]
[3, 4]
[2, 3, 4]
     */
    static List<List<Integer>> subSet(int[] arr){
       List<List<Integer>> outer=new ArrayList<>();
       // start with an empty subset
        outer.add(new ArrayList<>());
        for(int num:arr){
            int n=outer.size();// size of outer list 
            for(int i=0;i<n;i++){ 
            // create a new list by adding the current number to each existing subset in the outer list
            List<Integer> internal=new ArrayList<>(outer.get(i));
             internal.add(num);
             outer.add(internal);
            }

        }
        return outer;

    }
    static List<List<Integer>> subSetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            start=0;
             // if current and previous element is same s=e+1
             if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
             }
             end=outer.size()-1;
             int n=outer.size();
             for(int j=start; j<n; j++){
               List<Integer> internal=new ArrayList<>(outer.get(j));
               internal.add(arr[j]);
               outer.add(internal);
             }
        }
             return outer;

    }
    static int subSetSum(int[] arr,int target){
        List<Integer> list=new ArrayList<>();
        return helper(arr,target,0,0,list);
    }
    private static int helper(int[] arr,int target,int index,int Sum,List<Integer> list){
        if(index==target){
            System.out.println(list);
            return 1;
        }
        // base case: if the sum exceeds the target or we have processed all elements, return
        if(sum>target || index>=arr.length){
            return 0;
        }
        // include the current element in the subset
        list.add(arr[index]);
        helper(arr,target,index+1,sum+arr[index],list);
        // backtrack and exclude the current element from the subset
        list.remove(list.size()-1);
        helper(arr,target,index+1,sum,list);
    }
}
