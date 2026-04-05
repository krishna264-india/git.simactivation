public class SlidingWindowProblems {
    public static void main(String[] args){
        int[] nums={1,2,3,1};
        int k=3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;// If the current number is already in the set, we found a duplicate within the window
            }
            set.add(nums[i]);// Add the current number to the set
            if(i>=k){// If the window size exceeds k, remove the leftmost number from the set
                set.remove(nums[i-k]);// Remove the number that is sliding out of the window
            }
        }
        return false;// No duplicates found within any window of size k
    }
}
