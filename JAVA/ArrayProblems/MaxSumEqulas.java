package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class MaxSumEqulas {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        int k=3;
        System.out.println(maxSumEquals(nums,k)); // Expected output: 27 (8+9+10)
    }
    /* leetcodw 325
    * You are given an integer array nums and an integer k.
    * Find the maximum sum of a subarray of size k with all distinct elements.
    * Return the maximum sum of such a subarray. If there is no such subarray, return 0.
    * A subarray is a contiguous non-empty sequence of elements within an array.
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum=0;
        long windowSum=0;// 
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        // initialize the first window
        for(int i=0;i<k;i++){
            windowSum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // check if the first window has all distinct elements
        if(map.size()==k){
            maxSum=Math.max(maxSum,windowSum);
        }
        // slide the window
        for(int i=k;i<n;i++){
            windowSum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            windowSum-=nums[i-k];
        // decrease the count of the element going out of the window
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k])==0){// remove the element from the map if its count is 0
                map.remove(nums[i-k]);
            }
            if(map.size()==k){
                maxSum=Math.max(maxSum,windowSum);
            }
        }
        return maxSum;
    }
    /* 560 leetcode
    * Given an array of integers nums and an integer k,
    * return the total number of continuous subarrays whose sum equals to k.
     */
     public int subarraySum(int[] nums, int k) {
        // int count=0;
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i+1;j<n;j++){
        //         sum+=nums[j];
        //         if(sum==k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        int n=nums.length;
        // slide the window
        while(right<n){
            sum+=nums[right];
            // shrink the window from the left if sum exceeds k
            while(sum>k && left<=right){
                sum-=nums[left];
                left++;
            }
            if(sum==k){
                count++;
            }
            right++;
        }
        return count;
    }
    /*325 leetcode
    * Given an array of integers nums and an integer k,
    * return the total number of continuous subarrays whose sum equals to k.
    * Example 1:
    * Input: nums = [1,1,1], k = 2
    * Output: 2
    * Example 2:
    * Input: nums = [1,2,3], k = 3
     */
    public static long maxSumEquals(int[] nums,int k){
        int left=0;
        int right=0;
        int sum=0;
        int max=0;
        // slide the window
        while(right<nums.length){
            sum+=nums[right];
            if(right-left+1==k){// window size reached k
                max=Math.max(sum,max);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return max;
    }
}
