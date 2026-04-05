import java.util.Arrays;
import java.util.stream.IntStream;

public class Median {
    public static void main(String[] args){
        int[] arr1 = {3, 5, 1, 2, 4};      // Odd
        int[] arr2 = {3, 1, 2, 4};         // Even

        System.out.println("Median (odd): " + findMedian(arr1)); // Output: 3
        System.out.println("Median (even): " + findMedian(arr2)); // Output: 2.5
    }
    static double findMedian(int[] nums){
        Arrays.sort(nums);
        int n= nums.length;
        if(n%2!=0){
            return nums[n/2];
        }
        else{
            return (nums[n/2-1]+nums[n/2])/2.0;
        }
    }
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // int c[]=IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        // Arrays.sort(c);
        // int n=c.length;
        // if(n%2!=0){
        //     return c[n/2];
        // }
        // else{
        //     return (c[n/2-1]+c[n/2])/2.0;
        // }

        int m=nums1.length;
        int n=nums2.length;
        int[] merged=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                merged[k++]=nums1[i++];
            }else{
                merged[k++]=nums2[j++];
            }
        }
        while(i<m){
            merged[k++]=nums1[i++];
        }
        while(j<n){
            merged[k++]=nums2[j++];
        }
        int totalLength=m+n;
        if(totalLength%2!=0){
            return merged[totalLength/2];
        }else{
            return (merged[totalLength/2-1]+merged[totalLength/2])/2.0;
        }
      }
       public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int i=m;
        // for(int j=0;j<n;j++){
        //     nums1[i]=nums[j];
        //     i++;
        // }
        // Arrays.sort(nums1);
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
    }
}
