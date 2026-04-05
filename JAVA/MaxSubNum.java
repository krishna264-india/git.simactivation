public class MaxSubNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(maxFreqElements(nums,k));
    }
    public static int maxFreqElements(int[] nums,int k){
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(i>=k){
                int leftmost=nums[i-k];
                map.put(leftmost,map.get(leftmost)-1);
            if(map.get(leftmost)==0){
                map.remove(leftmost);
            }
        }
            if(i>=k-1){
                max=Math.max(max,map.get(nums[i]));
            }
        }
        return max;
    }
}
