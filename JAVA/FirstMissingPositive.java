/*
 * Given an unsorted integer array nums. Return the smallest positive integer 
 * that is not present in nums.
 * Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
 */
public class FirstMissingPositive {
    public static void main(String[] args){
        int[] nums={3,4,-1,1};

       System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int i=0;  	
        while (i<nums.length) {
            int check=nums[i]-1;
        //check if the number is in the range and not in the correct position
        if(nums[i] > 0 && nums[i]<=nums.length && nums[i]!=nums[check]) {
            swap(nums,i,check);
        }
        else {
            i++;
        }
    }
// check which number is missing in the index
    for(int index=0;index<nums.length;index++){
        if(nums[index]!=index+1){
            return index+1;
        }

    }
    return nums.length+1;
}


 static void swap(int[] nums, int f, int s) {
    int temp=nums[f];
    nums[f]=nums[s];
    nums[s]=temp;
    
}
}
