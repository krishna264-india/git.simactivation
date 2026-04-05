package ArrayProblems;

public class Adavanced {
    public static void main(String[] args) {
        
    }
    //trapping rain water
    static int trap(int[] height){
        int left=0, right=height.length-1;
        int leftMax=0, rightMax=0;
        int totalWater=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }
                else{
                    // if the current height is less than the left max, then we can trap water
                    totalWater+=leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }
                else{
                    totalWater+=rightMax-height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
    //Maximum profit in stock
    static int maxProfit(int[] prices){
        int minPrice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int price:prices){
            minPrice=Math.min(minPrice, price);
            maxprofit=Math.max(maxprofit, price-minPrice);
        }
        return maxprofit;
    }
    //Gas station problem - leetcode: 134
     public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0, totalCost=0, currentGas=0, start=0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
            currentGas+=gas[i]-cost[i];
            if(currentGas<0){
                start=i+1;
                currentGas=0;
            }
        }
        return totalGas<totalCost?-1:start;
    }
    //Next permutation
    static void nextPermutation(int[] nums){
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            // Swap the elements at index i and j
            swap(nums,i,j);
        }
        // After swapping, reverse the subarray from i+1 to the end of the array
        reverse(nums,i+1,nums.length-1);
    }
    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
}
}
