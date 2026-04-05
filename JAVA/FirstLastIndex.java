import java.util.Arrays;

/*
 * Given an array of integers nums sorted in non-decreasing order, 
 * find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity. 
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */

public class FirstLastIndex {
    public static void main(String[] args){
        int[] arr={2,3,4,5,5,8,5,9};
        int target=5;
        int[] n=firstLastIndex(arr, target);
        System.out.println(Arrays.toString(n));
           
    }
     static int[] firstLastIndex(int[] arr,int target){
        int[] ans={-1,-1};
        // ans[0]=seachFLindex(arr,target,true);
        // if(ans[0]!=-1){
        //    ans[1]=seachFLindex(arr, target, false);
        // }
        int start=seachFLindex(arr,target,true);
        int end=seachFLindex(arr,target,false);
        ans[0]=start;
        ans[1]=end;
        return ans;
    }

    
      static int seachFLindex(int[] arr,int target,boolean findIndex){
          int ans=-1;
           int start=0;
           int end=arr.length-1;
           while(start<=end){
                int mid=start+(end-start)/2;
                if(target<arr[mid]){
                     end=mid-1;
                }else if(target>arr[mid]){
                     start=mid+1;
                }else{
                    
                    ans=mid;
                
                
                    if(findIndex==true){
                       end=mid-1;
                    }
                    else{
                        start=mid+1;
                    }
                }
            }
            

           return ans;
      }
}


