import java.util.HashMap;

public class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        int n=nums.length;
        prefixSum=new int[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
        
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right+1]-prefixSum[left];
    }
    public int subarraySum(int[] nums, int k) {
        int res=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)) res+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
    public int subarraysDivByK(int[] nums, int k) {
        int res=0;
        int sum=0;
          HashMap<Integer,Integer> map=new HashMap<>();
          map.put(0,1);
          for(int i=0;i<nums.length;i++){
            sum=(sum+nums[i])%k;
            if(sum<0) sum+=k;
            if(map.containsKey(sum)){
                res+=map.get(sum);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }else{
                map.put(sum,1); 
            }
          }
          return res;
    }
    public static void main(String[] args){
        int[] nums={1,2,3,4,5};
        NumArray num= new NumArray(nums);
        System.out.println(num.sumRange(1,3));
    }
}
