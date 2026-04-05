public class PerfectSum {
     public int perfectSum(int[] nums, int target) {
        int n=nums.length;
        int[][] dp=new int[n+1][target+1];
        // Initialize the first column as 1
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        // Fill the dp table
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(nums[i-1]<=j){
                    // Include the current number
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}
