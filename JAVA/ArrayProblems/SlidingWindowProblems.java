package ArrayProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindowProblems {
    public static void main(String[] args) {
        int[] nums={-1,2,3,-5,4};
        System.out.println(maxSubArray(nums));

        int[] arr={1,2,3,4,5};
        int k=3;
        System.out.println(maxSumSubarray(arr,k));
    }

    //maximum sum subarray
    static int maxSubArray(int[] nums){
        //using kadane's algorithm
        int maxSum = nums[0];
        int currentSum = nums[0];
        for(int num:nums){
            currentSum=Math.max(num,currentSum+num);
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
    //maximum sum subarray of size k
    //leetcode 209
    public static int maxSumSubarray(int[] nums,int k){
        int maxSum=0;
        int windowSum=0;
        for(int i=0;i<nums.length;i++){
            windowSum+=nums[i];// add the current element to the window sum
            if(i>=k-1){// once we have added k elements to the window
                maxSum=Math.max(maxSum,windowSum);// update the maximum sum if needed
                windowSum-=nums[i-k+1];// remove the element that is sliding out of the window
            }
        }
        return maxSum;
    }
    //Longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s){
        int max=0;
        Set<Character> set=new HashSet<>();
        int left=0,right=0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max=Math.max(max,right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
    //Maximum average subarray of size k
    public static double findMaxAverage(int[] nums,int k){
        int maxSum=0;
        int windowSum=0;
        for(int i=0;i<nums.length;i++){
            windowSum+=nums[i];
  // once we have added k elements to the window, we can start calculating the average and updating the maximum average   
            if(i>=k-1){
                maxSum=Math.max(maxSum,windowSum);
                windowSum-=nums[i-k+1];//remove the element that is sliding out of the window
            }
        }
        return (double)maxSum/k;// return the maximum average
    }
    
    //Minimum window substring
    public static String minWindow(String s, String t){
        Map<Character,Integer> targetCount=new HashMap<>();// map to store the count of characters in t
        for(char ch:t.toCharArray()){
            targetCount.put(ch,targetCount.getOrDefault(ch,0)+1);
        }
        int left=0,matched=0,minLength=Integer.MAX_VALUE,startIndex=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(targetCount.containsKey(ch)){
                targetCount.put(ch,targetCount.get(ch)-1);
                if(targetCount.get(ch)>=0){
                    matched++;
                }
            }
// try to shrink the window from the left if we have matched all characters in t
            while(matched==t.length()){
                if(right-left+1<minLength){
                    minLength=right-left+1;
                    startIndex=left;
                }
                char leftChar=s.charAt(left);
                if(targetCount.containsKey(leftChar)){
                    targetCount.put(leftChar,targetCount.get(leftChar)+1);
                    if(targetCount.get(leftChar)>0){
                        matched--;
                    }
                }
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+minLength);
     }
     //reverse an array
     public static void reverse(int[] nums){
         int left=0,right=nums.length-1;
         while(left<right){
             int temp=nums[left];
             nums[left]=nums[right];
             nums[right]=temp;
             left++;
    }
}
//Longest subarray with sum K
public static int longestSubarrayWithSumK(int[] arr,int k){
    
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int max_len=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
    // if the sum from the beginning to the current index is equal to k, 
    // we can update the max_len directly to i+1
                max_len=i+1;
            }
            if(map.containsKey(sum)){
                max_len=Math.max(max_len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
            
        }
         return max_len;
         /*for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k){
                    max_len=Math.max(max_len,j-i+1);
                }
            }
          */
}
//Fruit into baskets - leetcode 904
public static int totalFruit(int[] fruits) {
    Map<Integer,Integer> map=new HashMap<>();
    int left=0;
    int maxFruits=0;
    for(int right=0;right<fruits.length;right++){
        map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
    // if we have more than 2 types of fruits in the current window,
    //  we need to shrink the window from the left until we have at most 2 types of fruits
        while(map.size()>2){
        // decrease the count of the fruit that is sliding out of the window
            map.put(fruits[left],map.get(fruits[left])-1);
            if(map.get(fruits[left])==0){
                map.remove(fruits[left]);
            }
            left++;
        }
    }
    maxFruits=Math.max(maxFruits,right-left+1);
    return maxFruits;
        
    }
}
