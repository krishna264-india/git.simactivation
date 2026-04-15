package ArrayProblems;

public class Kadannes {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxCircularSubArray(nums));
        System.out.println(maxProductSubArray(nums));
        
    }
    //Maximum subarray sum - leetcode: 53
    static int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int currentSum = nums[0];
        for(int num:nums){
            currentSum=Math.max(num,currentSum+num);
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    //Maximum circular subarray sum - leetcode: 918
    static int maxCircularSubArray(int[] nums){
        int maxSum=nums[0], curMax=0;
        int minSum=nums[0], curMin=0;
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
            // Kadane for max subarray
            curMax =Math.max(num,curMax+num);
            maxSum=Math.max(maxSum,curMax);

            // Kadane for min subarray
            curMin = Math.min(num, curMin+num);
            minSum = Math.min(minSum,curMin);
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
    //Maximum product subarray - leetcode: 152
    static int maxProductSubArray(int[] nums){
        int maxProduct=nums[0];
        // we need to keep track of the minimum product as well because a negative number can turn a minimum product into a maximum product
        int minProduct=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
        // store the current max product before updating it because it will be needed to update the min product
            int temp=maxProduct;
            maxProduct=Math.max(nums[i],Math.max(maxProduct*nums[i],minProduct*nums[i]));
            minProduct=Math.min(nums[i],Math.min(temp*nums[i],minProduct*nums[i]));
            result=Math.max(result,maxProduct);
            if(maxProduct>result){
                result=maxProduct;
            }
        }
        return result;
    }
}
