import java.util.ArrayList;
import java.util.List;
/*
 * 448. Find All Numbers Disappeared in an Array
 * Given an array nums of n integers where nums[i] is in the range [1, n], 
 * return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 
Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

 */
public class Disappeared {
    public static void main(String[] args){
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDuplicate(nums));
       
    }
    /*
     * 287. Find the Duplicate Number
     * Given an array of integers nums containing n + 1 integers 
     * where each integer is in the range [1, n] inclusive.

      There is only one repeated number in nums, return this repeated number.

       You must solve the problem without modifying the array nums and uses only constant extra space.
     */
    public static int findDuplicate(int[] nums) {
        int i=0;
        while(i < nums.length){
            if(nums[i]!=i+1){
                int element=nums[i]-1;
                if(nums[i]!=nums[element]){
                    swap(nums,i,element);
                }
                else{
                    return nums[i];
                }
            }
            else{
                i++;
            }

        }
        return -1;
    
} 
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        // just find the missing number
        List<Integer> ans=new ArrayList<>();
        for(int index=0;index<nums.length;index++){

            if(nums[index]!=index+1){
                ans.add(index+1);
            }

        }
        return ans;
        
    }
   static void swap(int[] nums,int first,int second){
         int temp=nums[first];
          nums[first]=nums[second];
          nums[second]=temp;
    }
}
