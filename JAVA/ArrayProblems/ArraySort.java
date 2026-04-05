package ArrayProblems;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
        int[] arr={3,2,1,5,4};
        int k=2;
        System.out.println(findKthLargest(arr,k));
        

    }
    // Sort colors (Dutch national flag)
    //leetcode 75
    static void sortColors(int[] nums){
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums[low],nums[mid]);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums[mid],nums[high]);
                high--;
            }
        }
    }
    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //215 Kth largest element
    static int findKthLargest(int[] nums,int k){
        Arrays.sort(nums);
        // the kth largest element will be at index length-k after sorting in ascending order
        return nums[nums.length-k];
    }
    //347 Top K frequent elements 
    static int[] topKfrequent(int[] nums,int k){
        //need to sort the elements based on their frequency
        Map<Integer,Integer> frequencyMap=new HashMap<>();
        for(int num:nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }
        // create a list of map entries and sort them by frequency
        List<Map.Entry<Integer,Integer>> sortedEntries=
        new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((a,b)->b.getValue().compareTo(a.getValue()));// sort in descending order of frequency
        // extract the top k elements
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=sortedEntries.get(i).getKey();
        }
        return result;
    }

}
