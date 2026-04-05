package ArrayProblems;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoPointers {
    public static void main(String[] args){
      int[] nums={2,9,11,12,34};
      int target=46;
      int[] ans=sum(nums,target);
      System.out.println(Arrays.toString(ans));

    }
    static int[] sum(int[]nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                 if(nums[i]+nums[j]==target){
                       return new int[] {i,j};
                 }
            }

        }
        return new int[]{-1,-1};

    }
    //Remove duplicates from sorted array
    static int removeDuplicates(int[] nums){
        if(nums.length==0) return 0;
        int j=1;// index to place the next unique element
        for(int i=1;i<nums.length;i++){
            // if the current element is different from the previous element, it's unique
            if(nums[i]!=nums[i-1]){ 
                nums[j]=nums[i];
                j++;// move the unique index forward
            }
        }
         return j;// number of unique elements
    }
    //contains with most water
    static int maxArea(int[] height){
        int left=0,right=height.length-1;
        int maxArea=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int w=right-left;
            maxArea=Math.max(maxArea,h*w);
            if(height[left]<height[right]){
                left++;
        }
            else{
                right--;
            }
        }
        return maxArea;
    }
    //Squares of sorted array
    static int[] sortedSquares(int[] nums){
        
        // for(int i=0;i<nums.length;i++){
        //     nums[i]=nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;
        int[] result=new int[nums.length];
        int left=0,right=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            // compare the absolute values of the left and right elements
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                // if the left element has a larger absolute value, square it and move the left pointer
                result[i]=nums[left]*nums[left];
                left++;
            }
            else{
                result[i]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
       
//3sum leetcode 15
    static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;// skip duplicates
            // use two pointers to find pairs that sum to -nums[i]
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) left++;// skip duplicates
                    while(left<right && nums[right]==nums[right+1]) right--;// skip duplicates
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
    //pair with given sum in a sorted array
    static int pairWithSum(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return left;// return the index of the first element in the pair
            }
            else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return -1;// return -1 if no pair is found
    }
    //merge two sorted arrays
    static int[] mergeSortedArrays(int[] nums1,int[] nums2){
        int[] merged=new int[nums1.length+num2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                merged[k++]=nums1[i++];
            }else{
                merged[k++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            merged[k++]=nums1[i++];
        }
        while(j<nums2.length){
            merged[k++]=nums2[j++];
    }
        return merged;
    }
    
    int maxLen(int arr[]) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int max_len=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                max_len=i+1;
            }
            if(map.containsKey(sum)){
                max_len=Math.max(max_len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
            
        }
        // int max=0;
        // for(int i=0;i<arr.length;i++){
        //     int sum=0;
        //     for(int j=i;j<arr.length;j++){
        //         sum+=arr[j];
        //         if(sum==0){
        //             max=Math.max(max,j-i+1);
        //         }
        //     }
        // }
         return max_len;
    }
    // unique paths in a grid
    // A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    // The robot can only move either down or right at any point in time.
    //  The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    /*
     * Given an integer array nums, 
     * rotate the array to the right by k steps, where k is non-negative.
     */
    public void rotate(int[] nums, int k) {
           k=k%nums.length;
           reverse(nums,0,nums.length-1);// reverse the entire array
           reverse(nums,0,k-1);// reverse the first k elements
           reverse(nums,k,nums.length-1);// reverse the remaining elements
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    /*
     * You are given an array of integers nums and an integer target.
      Return the number of non-empty subsequences of nums such that the sum of the minimum 
      and maximum element on it is less or equal to target. Since the answer may be too 
      large, return it modulo 109 + 7.
     */
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        // Precompute powers of 2
        int mod = 1000000007;
        int count = 0;
        int[] pow = new int[nums.length];// pow[i] = 2^i % mod
        pow[0] = 1;
        // Fill the pow array
        for (int i = 1; i < pow.length; i++) {
            // Calculate 2^i % mod
            pow[i] = (pow[i - 1] * 2) % mod;// 2^i % mod
        }
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences between left and right are valid
                count = (count + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int left=0, right=people.length-1;
        int boats=0;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            boats++;
        }
        return boats;
    }
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
