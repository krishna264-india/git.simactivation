/*
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
 * and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FindAllDuplicates {
    public static void main(String[] args){
        int[] nums={4,3,2,7,8,2,3,1};

        int[] ans=findErrorNums(nums);
        System.out.println(FindDuplicates(nums));

        System.out.println(Arrays.toString(ans));
 
    }
    public static List<Integer> FindDuplicates(int[] nums) {
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
        for(int index=0;index< nums.length;index++){

            if(nums[index]!=index+1){
                ans.add(nums[index]);
            }

        }
        return ans;
        
    }
   static void swap(int[] nums,int first,int second){
         int temp=nums[first];
          nums[first]=nums[second];
          nums[second]=temp;
        
    }
    /*
     * You have a set of integers s, which originally contains all the numbers from 1 to n.
     *  Unfortunately, due to some error, one of the numbers in s got 
     * duplicated to another number in the set, which results in repetition 
     * of one number and loss of another number.
     * 
     * You are given an integer array nums representing 
     * the data status of this set after the error.
     *Find the number that occurs twice and the number 
     that is missing and return them in the form of an array.

     Input: nums = [1,2,2,4]
     Output: [2,3]
     */
    public static int[] findErrorNums(int[] nums) {

        int i=0;
        while(i<nums.length){
           int element=nums[i]-1;
           if(nums[i]!=nums[element]){
                 swap1(nums,i,element);
           }
           else{
            i++;
           }
        }
        //find the missing index and duplicate nums
        for(int index=0;index<nums.length;index++){
               if(nums[index]!=index+1){
                   return new int[]{nums[index], index+1} ;
               }
        }
        return new int[] {-1,-1};
        
    }
    static void  swap1(int[] nums,int f,int s){
          int temp=nums[f];
          nums[f]=nums[s];
          nums[s]=temp;
    }
    public int findDuplicate(int[] nums) {
       Arrays.sort(nums);
       for(int i=0;i<nums.length-1;i++){
        if(nums[i]==nums[i+1]){
            return nums[i];
        }
       }
       return -1;
    }
}
