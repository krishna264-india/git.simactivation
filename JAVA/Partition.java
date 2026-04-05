public class Partition {
    public static void main(String[] args) {
        Partition p=new Partition();
        int[] nums={2,3,5,7,11};
        int result=p.countPartitions(nums);
        System.out.println(result);
    }
     public int countPartitions(int[] nums) {
        int n=nums.length;
        int totalSum=0;// calculate total sum
        // sum of all elements
        for(int num:nums){
            totalSum+=num;
        }
        int prefix=0;// prefix sum
        int count=0;
        for(int i=0;i<n-1;i++){
            prefix+=nums[i];
            int suffixSum=totalSum - prefix;// suffix sum
            if((prefix-suffixSum)%2 == 0){// check the condition
                count++;
            }
            return count;
    }
}
}
