import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxMin {

    public static void main(String [] args){
        int[] arr={12,14,13,20,25,1455,1233};

        int max=arr[0];
        for(int i=0;i<arr.length;i++){
             if(arr[i]>max){
                 max=arr[i];
              //   System.out.println(max);
             }
             
        }
        System.out.println("Minimum number is:"+max);

    }
    /*
     * Given arrival arr[] and departure dep[] times of trains on the same day, 
     * find the minimum number of platforms needed so that no train waits. 
     * A platform cannot serve two trains at the same time; 
     * if a train arrives before another departs, an extra platform is needed.

Note: Time intervals are in the 24-hour format (HHMM) , where the first two characters 
represent hour (between 00 to 23 ) and the last two characters represent minutes
 (this will be <= 59 and >= 0). Leading zeros for hours less than 10 are optional 
 (e.g., 0900 is the same as 900).

Examples:

Input: arr[] = [900, 940, 950, 1100, 1500, 1800], 
dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
     */
     public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n=arr.length;
        int a=0,d=0,max=0,plat=0;
        // two pointer approach
        while(a<n && d<n){
            if(arr[a]<=dep[d]){// a train is arriving before the other departs
                plat++;
                a++;
                max=Math.max(max, plat);
            }else{ // a train departs before the other arrives
                plat--;
                d++;
            }
        }
        return max;
    }
     public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result= new ArrayList<>();
        int minDifr=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int currDiff= arr[i+1]-arr[i];// calculate the difference between two adjacent elements
            if(currDiff<minDifr){
                minDifr=currDiff;
                result.clear();
                addPairToRes(arr[i],arr[i+1],result);
            }
            else if(currDiff==minDifr)
                    addPairToRes(arr[i],arr[i+1],result);
            }
            return result;
        }
        private void addPairToRes(int num1, int num2, List<List<Integer>> res){
            List<Integer> pair=Arrays.asList(num1,num2);
            res.add(pair);
        }
/*
 * You are given a binary string s.

You can perform the following operation on the string any number of times:

Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
Move the character s[i] to the right until it reaches the end of the string or another '1'. 
For example, for s = "010010", if we choose i = 1, the resulting string will be s = "000110".
Return the maximum number of operations that you can perform.
 */
        public int maxOperations(String s) {
         int cnt=0;
         int oneCount=0;
         int n=s.length();
         for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                oneCount++;
            }else if(s.chatAt(i)=='0' && oneCount>0){
                cnt++;
                oneCount--;
            }
         }
         return cnt;
    }
    public int minSubarray(int[] nums, int p) {
        int totalMod=0;
        for(int num:nums){
            totalMod=(totalMod+num)%p;
        }
        if(totalMod==0) return 0;
        Map<Integer,Integer> prefixMap=new HashMap<>();
        prefixMap.put(0,-1);
        int prefixSum=0;
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            prefixSum=(prefixSum+nums[i])%p;
            int target=(prefixSum - totalMod + p)%p;
            if(prefixMap.containsKey(target)){
                minLength=Math.min(minLength,i-prefixMap.get(target));
            }
            prefixMap.put(prefixSum,i);
        }
        return minLength==Integer.MAX_VALUE || minLength==nums.length?-1:minLength; 
    }
    public int countTriples(int n) {
        int count=0;
        for(int a=1;ia<=n;a++){// iterate through a
            for(int b=1;b<=n;b++){// iterate through b
                int cSquare=a*a+b*b;// calculate c^2
                int c=(int)Math.sqrt(cSquare+1);// calculate c
                if(c<=n && c*c==cSquare){// check if c is an integer and within bounds
                    count++;
                }
            }
        }
        return count;
    }
    /*it's greedy approach
        * You are given a 0-indexed integer array happiness and an integer k.
        * You can perform the following operation at most k times:
        * Choose an index i such that 0 <= i < happiness.length and
        * happiness[i] > 0, then set happiness[i] = happiness[i] - 1.
        * Your goal is to maximize the sum of the elements in the happiness array after
        * performing the operations.
        * Return the maximum possible sum of the elements in the happiness array after
        * performing the operations.
     */
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);// sort the array
        long maxSum=0;
        int n=happiness.length;
         for (int i = 0; i < k && i < n; i++) {// iterate through the first k elements
        int value = happiness[n - 1 - i] - i;// decrease the value by i
        if (value > 0) {// check if the value is positive
            maxSum += value;// add to maxSum if positive
        }
    }
    return maxSum;
    }

    }
    

