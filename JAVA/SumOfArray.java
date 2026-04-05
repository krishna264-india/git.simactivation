import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class SumOfArray {
    public static void main(String[] args) {
        int[][] arr={{10,23,45},
                     {34,67,89},
                     {32,13,15}
                    };
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
              sum=sum+arr[i][j];
            }
            System.out.println(sum); 
        }
        //System.out.println(sum);
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<nums.length;i++){

            dp[i]= Math.min(dp[i-1]+nums[i-1] ,dp[i-2]+nums[i-1]);
        }
        return dp[dp.length-1];
        
    }
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        

        int sum=0;
        for(int i=0;i<s.length();i++){
            int currentVal= map.get(charAt(i));
            int nextVal=(i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            if(currentVal>=nextVal){
                sun+=currentVal;
            }
            else{
                sum-=currentVal;
            }
        }
         return sum;
    }
}
