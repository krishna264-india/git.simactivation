package ArrayProblems;

public class ARraysProblems {
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(check(nums));

        
    }
    // 1752. Check if Array Is Sorted and Rotated
     public static boolean check(int[] nums) {
         int n=nums.length;
// count the number of times the current element is greater than the next element
            int count=0;
            for(int i=0;i<n;i++){
            // compare current element with the next element (circularly)
                if(nums[i]>nums[(i+1)%n]){
                    count++;
                }
            }
            return count<=1;// if count is 0 or 1, the array is sorted and rotated
    }
    // remove duplicates from sorted array
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int j=1;// index to place the next unique element
        for(int i=1;i<nums.length;i++){
            // if the current element is different from the previous element, it's unique
            if(nums[i]!=nums[i-1]){ 
                nums[j]=nums[i];
                j++;// move the unique index forward
            }
        }
        return j;// number of unique elements
    }
    static int missingNumber(int[] nums) {
        // int n=nums.length;
        // int expectedSum=n*(n+1)/2;// sum of first n natural numbers
        // int actualSum=0;
        // for(int num:nums){
        //     actualSum+=num;// sum of elements in the array
        // }
        // return expectedSum-actualSum;// the difference is the missing number

        int n=nums.length;
        Arrays.sort(nums);// sort the array
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                return i;// the first index that doesn't match the value is the missing number
            }
        }    
        return n;// if all numbers from 0 to n-1 are present, then n is the missing number    
    }

    // 283. Move Zeroes
    public static void moveZeroes(int[] nums) {
        int j=0;// index to place the next non-zero element
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
             int temp=nums[i];
             nums[i]=nums[j];
             nums[j++]=temp;
            }
        }
}
    //left rotate an array by one
    public static void leftRotate(int[] nums) {
        if(nums.length==0) return;
        // store the first element to be moved to the end of the array
        int firstElement=nums[0];
        for(int i=1;i<nums.length;i++){
        // shift each element to the left
            nums[i-1]=nums[i];
        }
    // place the first element at the end of the array
        nums[nums.length-1]=firstElement;
    }
    // right rotate array
    public static void rightRotate(int[] nums) {
        if(nums.length==0) return;
        int lastElement=nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--){
        // shift each element to the right
            nums[i]=nums[i-1];
        }
    // place the last element at the beginning of the array
        nums[0]=lastElement;
    }
    // 189. Rotate Array
    public static void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;// in case k is greater than n
        // reverse the entire array
        reverse(nums,0,n-1);
        // reverse the first k elements
        reverse(nums,0,k-1);
        // reverse the remaining n-k elements
        reverse(nums,k,n-1);
    }
    private static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
