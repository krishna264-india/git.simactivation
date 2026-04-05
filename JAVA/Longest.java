public class Longest {
    public static void main(String[] args){
        int[] nums={1,2,3};
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        } 
        int longestStreak=0;
        for(int num:numSet){
            if(!numSet.contains(num-1)){
                int currNum=num;
                int currSteak=1;
                while(numSet.contains(currNum+1)){
                    currNum+=1;
                    currSteak+=1;
                }
                longestStreak=Math.max(longestStreak, currSteak);
            }
        }
        return longestStreak;
}
}
