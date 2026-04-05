import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SumOfTwo {
    public static void main(String[] args){
        int[] arr= {1,2,3,4,5,6,7,8};
        int target= 10;
        int[] result= twoSum(arr, target);
        System.out.println(result);
        System.out.println(" the two numbers are "+result[0] +"and"+result[1]);
        int sum=0;
        for(int i=0;i< arr.length;i++){
            sum=sum+arr[i];
        }
        System.out.println("sum of array element is "+sum);
        int[] nums={21,4,7,6};
        System.out.println("sum of four divisors is "+sumFourDivisors(nums));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];// find the complemet of the current number
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSum(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return new int[]{left,right};
            }else if(sum <target){
                 left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    public static int twoSum(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target){
                return i+j;
            }
        }
        }
        return -1; 
    } 
    public static int sumFourDivisors(int[] nums) {
         int total = 0;

        for (int num : nums) {// for each number in the array
            int sum = 0;
            int count = 0;

            for (int i = 1; i * i <= num; i++) {// find divisors up to the square root of num
                if (num % i == 0) {
                    int d1 = i;// divisor
                    int d2 = num / i;// corresponding divisor

                    count++;
                    sum += d1;

                    if (d1 != d2) {
                        count++;
                        sum += d2;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                total += sum;
            }
        }
        return total;
    }
}
