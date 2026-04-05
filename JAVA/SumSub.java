import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringBuilder;

public class SumSub {
    public static void main(String[] args){
        String s= "abcabc";
        System.out.println(reverseWord(s));

        int[] arr={1,2,3,4,5};
        int[] prices= {1000,200,300,400,500};
        int profit=maxProfit(prices);
        System.out.println("Maximum profit is:"+ profit);
        int ans= maxSubArray(arr);
        System.out.println(ans);
    }
    public static int maxSubArray(int[] nums) {
        int currentSum=nums[0];
        int maxSum=nums[0];
        for(int i=0;i<nums.length;i++){
            currentSum=Math.max(nums[i],currentSum+nums[i]);
            maxSum=Math.max(maxSum,currentSum);
            // int sum=0
            //    for(int j=i;j<nums.length;j++){
            //          sum+=nums[j];
            //    }
            //    if(sum>maxSum){
            //     maxSum=sum;
            //    }
        }

        return maxSum;
    }
    /*leetcode :121
      Best Time to Buy and Sell Stock 
     * You are given an array prices where prices[i] is 
     * the price of a given stock on the ith day.

     ->You want to maximize your profit by choosing a single day to buy one stock 
     and choosing a different day in the future to sell that stock.
    -> Return the maximum profit you can achieve from this transaction. 
     If you cannot achieve any profit, return 0.
     */

    public static int maxProfit(int[] prices) {
        int minPrice=Integer.MIN_VALUE;
        int maxProfits=0;
        // for(int i=0;i<prices.length;i++){
        //     if(prices[i]<minPrice){
        //         minPrice=prices[i];
        //     }
        //     else{
        //         int profit=prices[i]-minPrice;
        //         maxProfit=Math.max(maxProfit,profit);
        //     }
        // }
        for(int price:prices){
            minPrice=Math.max(minPrice,price);
            maxProfits=Math.max(maxProfits,price-minPrice);
        }
        return maxProfits;

    }
  //283
  /* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zeroes.
   o/p: [0,1,0,3,12] -> [1,3,12,0,0]
   */
    public static void moveZeroesToEnd(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[count];
                nums[count]= nums[i];
                nums[i]=temp;
                count++;
            }
        }
        
    }
    public static int maxSubArraySum(int[] arr){
        int sum=0;
        int max_len=0;
        Map<Integer,Integer> map=new HashMap<>();
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
         return max_len;
    }
    /* Given an integer array arr, find the length of the longest subarray whose sum is equal to 0.
     * Example 1:
Input: arr = [1, -1, 3, 2, -2, -3]
Output: 5
Explanation: The longest subarray with sum 0 is [1, -1, 3, 2, -2] or [-1, 3, 2, -2, -3].
Example 2:
Input: arr = [1, 2, 3]
Output: 0
Explanation: There is no subarray with sum 0.
     */
    public static int longestZeroSumSubarray(int[] arr){
        int sum=0;
        int max_len=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
             sum+=arr[i];
            if(sum==0){
                max_len=i+1;// Update max_len to the length of the subarray from index 0 to i
            }
            if(map.containsKey(sum)){
                max_len=Math.max(max_len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
            
        }
         return max_len;
    }
    public static int longestZeroSumSubarrayBruteForce(int[] arr){
        int sum=0;
        int max_len=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==0){
                    max_len=Math.max(max_len,j-i+1);
                }
            }
        }
         return max_len;
    }

    public static void moveZeroes(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[count];
                nums[count]= nums[i];
                nums[i]=temp;
                count++;
            }
        }
        
    }
}
    //238
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]* nums[i-1];
        }
        int R=1;// R will hold the product of elements to the right of the current index
        for(int i=n-2;i>=0;i--){
            res[i]= res[i]*R;
            R*=nums[i+1];
        }
        return res;
        
    }
    //11
    public int maxArea(int[] height) {
        int maxArea=0;
        int left=0,right=height.length-1;
        while(left<right){
            int h=Math.min(height[left],height[right]);// height of the line
            int w= right-left;// width
            maxArea=Math.max(maxArea,h*w);// area
            // Move the pointer pointing to the shorter line inward
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
        
    }
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int sum=0;
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res= new ArrayList<>();
            Arrays.sort(nums);
            for(int i=0;i<nums.length-3;i++){
                if( i>0 && nums[i]== nums[i-1]){
                    continue;
                }
                for(int j=i+1;j<nums.length-2;j++){
                  if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                  }
                    int left=j+1,right=nums.length-1;
                    while(left<right){
                        int sum=nums[i]+ nums[j]+nums[left]+nums[right];
                        if(sum==target){
                            res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                            while( left<right && nums[left]== nums[left+1]) left++;
                            while(left<right && nums[right]==nums[right-1]) right--;
                            left++;
                            right--;
                        }
                        else if(sum<target){
                            left++;
                        }
                        else{
                            right--;
                        }
                    }
                }
            }
             return res;
        }
        public static String reverseWord (String s){
            String[] words= s.spilt(" ");
            for( int i=0;i<words.length;i++){
                StringBuilder sb=new StringBuilder(words[i]);
                sb.reverse();
                words[i]=sb.toString();
            }
            return String.join(" ",words);
        }
        public static String reverseWordByWord (String s){
            String[] words=s.split(" ");
            StringBuilder sb=new StringBuilder();
            for(int i=words.length-1;i>=0;i--){
                sb.append(words[i]);
                sb.append(" ");
            }
            return sb.toString();
        }
        public static boolean isSubsequence(String s, String t) {
            int i=0,j=0;
            while(i<s.length() && j<t.length()){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                }
                j++;
            }
            return i==s.length();
        }
    

