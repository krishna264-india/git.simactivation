package GreedyProblem;

import java.util.Arrays;

public class MinimumCost {
    public static void main(String[] args) {
        MinimumCost mc = new MinimumCost();
        int[] costs = {1, 2, 3};
        int k = 2;
        System.out.println(mc.minimumCost(costs, k)); // Expected output: 4

        int[] nums1= {4,1,2};
        int[] nums2= {1,3,4,2};
        int [] result=nextGreaterElements(nums1,nums2);
        System.out.println(Arrays.toString(result)); // Expected output: [ -1, 3, -1 ]      
    }
    //1080 leetcode
    /* You are given an array of integers nums,
    * where the cost of an element is the sum of its digits.
    * Return the minimum cost of an element in the array.
    * Example 1:
    * Input: nums = [34,23,1,24,75,33,54,8]
    *   Output: 10
    * Explanation:
    * The cost of the elements are as follows:
    * - 34 -> 3 + 4 = 7
     */
     public int minimumCost(int[] nums) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=min1){
                min2=min1;
                min1=num;
            }
            else if(num<min2){
                min2=num;
            }
        }
        return min1+min2;
    }
    public int[] nextGreaterElements(int[] nums1,int[] nums2) {
        int n=nums2.length;
        int[] result=new int[nums1.length];// default value -1
        Arrays.fill(result,-1);// fill the result array with -1
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    for(int k=j+1;k<n;k++){// find the next greater element
                        if(nums2[k]>nums1[i]){// if found
                            result[i]=nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
