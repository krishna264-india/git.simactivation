package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class Arrayhash {
    public static void main(String[] args) {
        int[] nums={2,3,4,3};
        System.out.println(majorityElement(nums));
        int[] arr={1,2,3,4,5};
        int k=3;
        System.out.println(maxSumSubarray(arr,k));
        
    }
    //leetcode 169
    static int majorityElement(int[] nums){
        Map<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int majority=n/2;
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
            if(hm.get(num)>majority) return num;
        }
        return -1;
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
// initialize the map with sum 0 and count 1 to handle the case when a subarray itself equals k
        map.put(0,1);
        int count=0;
        int sum=0;
        for(int num:nums){
            sum+=num;// update the cumulative sum
            if(map.containsKey(sum-k)){// check if there is a subarray that sums to k
                count+=map.get(sum-k);// add the count of such subarrays
            }
            map.put(sum,map.getOrDefault(sum,0)+1);// update the count of the current sum in the map
        }
        return count;
    }
    //longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set=new hashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest=0;
        for(int num:nums){
            if(!set.contains(num-1)){// check if it's the start of a sequence
                int currentNum=num;
                int currentStreak=1;
                while(set.contains(currentNum+1)){// count the length of the sequence
                    currentNum++;
                    currentStreak++;
                }
                longest=Math.max(longest,currentStreak);// update the longest sequence found
            }
        }
        return longest;
    }
}
