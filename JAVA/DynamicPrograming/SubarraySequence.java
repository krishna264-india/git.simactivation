package DynamicPrograming;

public class SubarraySequence {
    public static void main(String[] args) {
        SubarraySequence ss=new SubarraySequence();
        int[] nums={2,7,9,3,1};
        System.out.println(ss.rob(nums)); // Expected output: 12

    }
    /*
    * You are a professional robber planning to rob houses along a street. 
    Each house has a certain amount of money stashed, 
    * the only constraint stopping you from
    * robbing each of them is that adjacent houses have security systems connected and
    *  it will automatically contact the police
    * if two adjacent houses were broken into on the same night.
    * Given an integer array nums representing the amount of money of each house,
    * return the maximum amount of money you can rob tonight without alerting the police.
    * Example 1:
    * Input: nums = [1,2,3,1]
    * Output: 4
    * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    * Total amount you can rob = 1 + 3 = 4.
    * Example 2:
    * Input: nums = [2,7,9,3,1]
    * Output: 12
    * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    * Total amount you can rob = 2 + 9 + 1 = 12.
     */ 
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];// base case
        // base case
        dp[1]=Math.max(nums[0],nums[1]);// either rob the first house or the second house
        // fill the dp array
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);// either skip the current house or rob it
        }
        // the last element of dp array will have the answer
        return dp[n-1];
    }
    /* 
    * A message containing letters from A-Z can be encoded into numbers using the following mapping:
    * 'A' -> "1"
    * 'B' -> "2"
    * ...
    * 'Z' -> "26"
     */
     public int numDecodings(String s) {
        int n=s.length();
        if(n==0 || s.charAt(0)=='0') return 0;
        int[] dp=new int[n+1];//dp[i] will store the number of ways to decode the substring of length i
        dp[0]=1;// base case: empty string
        dp[1]=1;// base case: first character
        for(int i=2;i<=n;i++){
            int oneDigit=Integer.parseInt(s.substring(i-1,i));// single digit
            int twoDigit=Integer.parseInt(s.substring(i-2,i));// two digits
            if(oneDigit>=1 && oneDigit<=9){
                dp[i]+=dp[i-1];// valid single digit
            }
            if(twoDigit>=10 && twoDigit<=26){
                dp[i]+=dp[i-2];// valid two digits
            }
        }
        return dp[n];// the last element of dp array will have the answer
    }
    /*
    * Given a non-empty array containing only positive integers, 
    find if the array can be partitioned into two subsets such that the sum of elements in 
    both subsets is equal.
    * Example 1:
    * Input: nums = [1,5,11,5]
    * Output: true
    * Explanation: The array can be partitioned as [1, 5, 5] and [11].
    * Example 2:
    * Input: nums = [1,2,3,5]
    * Output: false
    * Explanation: The array cannot be partitioned into equal sum subsets.
     */
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2!=0) return false;// if total sum is odd, cannot partition
        int target=totalSum/2;
        int n=nums.length;
        // dp[i][j] will be true if sum j can be achieved using first i numbers
        boolean[][] dp=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;// base case: sum 0 can always be achieved
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j){// current number can be included
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];// include or exclude the current number
                }else{
                    dp[i][j]=dp[i-1][j];// exclude the current number
                }
            }
        }
        return dp[n][target];
    }
}
