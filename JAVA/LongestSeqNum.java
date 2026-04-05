import java.util.Set;

public class LongestSeqNum {

    public static void main(String[] args) {
        
    }
      static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longestStreak=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int currnum=num;
                int currStreak=1; 

                while(set.contains(currnum+1)){
                    currnum++;
                    currStreak++;
                }
                longestStreak=Math.max(longestStreak,currStreak);
            }
        }
        return longestStreak;
      }
    
}
