public class EvenDigits {
    public static void main(String[] args){
       int[] nums={234,3,2,3456,12,345};
       int ans=findNumbers(nums);
       System.out.println(ans);
       int low=3;
       int high=7;
         int result=countOdds(low,high);
            System.out.println(result);
    }
    public static int findNumbers(int[] nums) {
        int count=0;
        for(int num:nums){
            if(even(num)){
               count++;
            }

        }
        return count;
    }
     public static boolean even(int num){
        int numOfDigits=Digits(num);
        if(numOfDigits%2==0){
            return true;
        }else{
            return false;
        }

     }
     public static int Digits(int num){
        int count=0;
        while(num>0){
            count++;
            num/=10;

        }
          return count;
     }
     public static int countOdds(int low, int high) {
        // int left=low%2==0? low+1:low;
        // int right=high%2==0? high-1:high;
        // if(left>right){
        //     return 0;
        // }
        // return ((right - left)/2) + 1;

        int totalNumbers=high - low + 1;// total numbers in the range
        if(totalNumbers%2==0){
            return totalNumbers/2;
        }else{
            if(low%2==1 || high%2==1){
                return totalNumbers/2 + 1;
            }
        }
        return totalNumbers/2;
    }
}
