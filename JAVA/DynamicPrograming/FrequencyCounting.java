package DynamicPrograming;

import java.util.List;

public class FrequencyCounting {
    public static void main(String[] args) {
        FrequencyCounting fc = new FrequencyCounting();
        System.out.println(fc.areOccurrencesEqual("abacbc")); // Expected: true
        System.out.println(fc.areOccurrencesEqual("aaabb"));  // Expected: false
        
    }
    /*
    leetcode 1941
    * Given a string s, return true if the frequency of each character in the string is 
    unique, or false otherwise.
    * Example 1:
    * Input: s = "abacbc"
    * Output: true
    * Explanation: The characters 'a', 'b', and 'c' each appear twice
     */
     public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer> freqMap=new HashMap<>();
        for(char c:s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        Set<Integer> freqSet=new HashSet<>();
        for(int freq:freqMap.values()){
            if(freqSet.contains(freq)){
                return false; // if the frequency is already in the set, return false
            }
            freqSet.add(freq); // add the frequency to the set
        }
        return true; // all frequencies are unique
        
}
/*

/**
 * @param arr
 * @return List<List<Integer>> minimum absolute difference pairs
 * 
 * leetcode 1200
 * Given an array of distinct integers arr, find all pairs of elements with the minimum 
 * absolute difference of any two elements.
 * Return a list of pairs in ascending order(with respect to pairs),
 * each pair [a, b] followsa < b and b - a == minabsluteDifference
 * Example 1:   
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. The pairs with 
 * minimum absolute difference are [1,2], [2,3], and [3,4].
 */
public List<List<Integer>> minimumAbsDifference(int[] arr) {
       List<List<Integer>> result=new ArrayList<>();
       Arrays.sort(arr);// sort the array to find pairs with minimum absolute difference
       int minDiff=Integer.MAX_VALUE;;
       for(int i=1;i<arr.length;i++){
        minDiff=Math.min(minDiff,arr[i]-arr[i-1]);// find the minimum difference
       }
       for(int i=1;i<arr.length;i++){
        if(arr[i]-arr[i-1]==minDiff){
            result.add(Arrays.asList(arr[i-1],arr[i]));// add the pair to the result list
        }
       } 
         return result;
    }
}
