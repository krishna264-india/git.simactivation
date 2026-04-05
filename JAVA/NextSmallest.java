import java.util.Arrays;
/*
 * Given a sorted array of integers and a target value, find the largest element 
 * in the array that is smaller than the target. If no such element exists, return -1.
 * Example 1:
 * Input: arr = [1, 2, 4, 6, 8], target = 5
 * Output: 4
 * Explanation: The largest element smaller than 5 is 4.
 * which scenarios binary search is used:
 * 1. Find exact element
 * 2. Finding the next smallest or largest element
 * 3. Finding the first or last occurrence of an element
 * 4. Finding the square root of a number
 * 5. Search range
 * 6. Searching in a rotated sorted array
 * 7. Finding the peak element in an array
 * 8. Allocating resources or dividing tasks
 * 9. Optimizing functions
 * 10. Searching in infinite or unknown-sized arrays
 * 10. Finding the minimum in a sorted and rotated array
 * 11. Finding the maximum in a bitonic array
 * 12. Finding the closest element to a given value
 * 13. Finding the range of a target value in a sorted array
 */
public class NextSmallest {
    public static void main(String[] args) {
        int[] arr={1,2,4,6,8};
        int target=5;
        int result=nextSmallest(arr,target);
        System.out.println(result);
        
    }
    public int nextSmallest(int[] arr,int target){
        if (arr == null || arr.length == 0) {
            return -1; // Empty array case
        }
        int left=0, right=arr.length-1;
        int result=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]<target){
                result=arr[mid];
                left=mid+1;
            }else if(arr[mid]==target){
                return (arr[mid]>0)?arr[mid-1]:-1;// if mid is 0 then no smaller element
            }else {
                right=mid-1;
            }
        }
        return result;
    }
    //Finding the square root of a number
    public static int sqrt(int n){
        if(n==0 || n==1) return n;
        int left=1,right=n/2,ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid==n/mid){
                return mid;
            }else if(mid<n/mid){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
    //Finding the closest element to a given value
    public static int findClosest(int[] arr,int target){
        if(arr==null || arr.length==0) return -1;
        int left=0,right=arr.length-1;
        int closest=arr[0];
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                return arr[mid];
            }else if(arr[mid]<target){
                if(Math.abs(arr[mid]-target)<Math.abs(closest-target)){
                    closest=arr[mid];
                }
                left=mid+1;
            }else{
                if(Math.abs(arr[mid]-target)<Math.abs(closest-target)){
                    closest=arr[mid];
                }
                right=mid-1;
            }
        }
        return closest;
    }
}
