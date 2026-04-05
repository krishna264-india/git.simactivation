/*
 * You are given an integer mountain array arr of length n 
 * where the values increase to a peak element and then decrease.

Return the index of the peak element.

OR:-
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. 
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words,
 an element is always considered to be strictly greater than a neighbor that is outside the array.
 Your task is to solve it in O(log(n)) time complexity.
 */

public class PeakArray {
    public static void main(String[] args){
        int[] arr={1,2,3,5,7,6,3,2};
        System.out.println(peakIndexInMountainArray(arr));

    }
    public static int peakIndexInMountainArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start < end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                 end=mid;
            }else{
                start=mid+1;
            }

        }
        return start;
    }
}
