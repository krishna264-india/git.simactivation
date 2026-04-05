package ArrayProblems;

public class ArraysIntermediateProblems {
    public static void main(String[] args) {
        
    }
    static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
}
    }
    //longest consecutive sequence in an unsorted array
    static int longestConsecutive(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        // add all numbers to the set for O(1) lookups
        for(int num:nums){
            set.add(num);
        }
        int longestStreak=0;
        // iterate through the set and find the longest consecutive sequence
        for(int num:set){
            // only start counting if the current number is the start of a sequence (i.e., num-1 is not in the set)
            if(!set.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;// at least one number in the sequence
                while(set.contains(num+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
        }
    }
        return longestStreak;
    }
    
}
