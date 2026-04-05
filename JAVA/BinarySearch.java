public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={-1,0,3,5,9,12};
        int target=8;
        int ans=binarySearch(arr, target);
        System.err.println(ans);
        int[] arr1={1,2,2,2,3,4};
        int target1=2;
        int first=firstOccrence(arr1, target1);
        System.err.println(first);
        int[] nums={1,1,2,3,3,4,4,8,8};
        int result=singleNonDuplicate(nums);
        System.err.println(result);
    }
    static int binarySearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
           int mid=start+(end-start)/2;
           if(target<arr[mid]){
                end=mid-1;
           }
           else if(target>arr[mid]){
                start=mid+1;
           }else{
            return mid;
           }
        }
        return-1;
    }
    /*
     * You are given a sorted array consisting of only integers 
     * where every element appears exactly twice,
     * except for one element which appears exactly once.
     */
    public static int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mid%2==1) mid--;// ensure mid is even
             if(nums[mid]==nums[mid+1]){// unique element is in the right half
                start=mid+2;// move to the next pair
            }else{
                end=mid;// unique element is in the left half including mid
            }
        } 
        return nums[start];// start and end converge to the unique element
    }
    /* 35 leetcode
     * Given a sorted array of distinct integers and a target value, 
    return the index if the target is found. 
    If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
Example 1:  
Input: nums = [1,3,5,6], target = 5
Output: 2
     */
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){// Find the first position where target can be inserted
                return i;// Return the index
            }
        }
        return nums.length;// If target is greater than all elements, return the length of the array
    }
    // leetcode 34
    static int firstOccrence(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        int result=-1;// Initialize result to -1 to indicate target not found
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
             }else{
                result=mid;// Update result with the current index of target
                end=mid-1;// Continue searching in the left half to find the first occurrence
             }
            }
        return result;// Return the index of the first occurrence of target, or -1 if not found
        }
    }

