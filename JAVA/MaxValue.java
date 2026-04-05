import java.util.Arrays;

public class MaxValue {
    public static void main(String[] args) {
        int[][] arr={ {23,35,45,65},
                       {32,5,90},
                       {89,87,76,78},
                       {88,67,107,100}
                      };

                      System.out.println(maxValue(arr));
        
    }
    static int maxValue(int[][] arr){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr[i].length;j++){
               sum+=arr[i][i];

            }
              if(sum>ans){
                ans=sum;

              }
            }
           
            return ans;
        }
        public boolean isPowerOfFour(int n) {
          if(n<=0) return false;
          while(n%4==0) n/=4;
          return true;
    }
     public String largestNumber(int[] nums) {
       // Convert integers to strings for comparison
       String[] strNums=new String[nums.length];
       for(int i=0;i<nums.length;i++){
        strNums[i]=String.valueOf(nums[i]);
       }
       // Sort strings based on custom comparator
       Arrays.sort(strNums,(a,b)->(b+a).compareTo(a+b));
        // Handle the case where all numbers are zeros
        if(strNums[0].equals("0")) return "0";
        StringBuilder sb=new StringBuilder();
        for(String str:strNums){
            sb.append(str);
        }
        return sb.toString();
    }   

    }

