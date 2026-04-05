package DynamicPrograming;

public class KadannesAlgo {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums)); // Expected output: 6 (subarray [4,-1,2,1])

        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int k=3;// size of the subarray
        System.out.println(maximumSubarraySum(arr,k)); // Expected output: 27 (subarray [8,9,10])
    }
    /* 53. Maximum Subarray
    * Given an integer array nums, find the contiguous subarray 
    (containing at least one number) which has the largest sum and return its sum.
     */
    public static int maxSubArray(int[] nums){
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;
        for(int i=1;i<nums.length;i++){
            currentSum=Math.max(nums[i],currentSum+nums[i]);
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
    // leetcode 2300

    public static long maximumSubarraySum(int[] arr,int k){
        long maxSum=0;
        long windowSum=0; 
        int n=arr.length;
        // initialize the first window
        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }
        maxSum=Math.max(maxSum,windowSum);
        // slide the window
        for(int i=k;i<n;i++){
            windowSum+=arr[i];
            windowSum-=arr[i-k];
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
}
