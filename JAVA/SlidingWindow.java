import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SlidingWindow {
    public static void main(String[] args){
        String str= "abcabcbb";
        System.out.println(nonRepeatingCharacters(str));

    }
     static String nonRepeatingCharacters(String str){
        // String result="";
        // for(int i=0;i<str.length();i++){
        //     int count=0;
        //     if(str.charAt(i)!=' '){
        //         for(int j=0;j<str.length();j++){
        //             if(str.charAt(i)==str.charAt(j) && i!=j){
        //                 count++;
        //                 break;
        //             }
        //         }
        //         if(count==1){
        //            result+= str.charAt(i);
        //            break;
        //         }
        //     }
        // }
        // return result;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(map.get(ch)==1){
                return String.valueOf(ch);
            }
        }
        return "";
    }
    static String removeDuplicateChar(String str){
        String result="";
        for(int i=0;i<str.length();i++){
            int count=0;
            if(str.charAt(i)!=' '){
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(i)==str.charAt(j) && i!=j){
                        count++;
                    }
                }
                if(count==0){
                    result+=str.charAt(i);
                }
            }
        }
        return result; 
    }
    static String countOccurenceOfCharacters(String str){
        String result="";
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
    }
    static String printDuplicates(String str){
        String result="";
        for(int i=0;i<str.length();i++){
            int count=0;
            if(str.charAt(i)!=0){
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(i)==str.charAt(j) && i!=j){
                        count++;
                    }
                }
                if(count==1) result+=str.charAt(i)+" ";
            }
        }
         return result;
    }
    static String printDuplicatesAndCount(String str){
        String result="";
        for(int i=0;i<str.length();i++){
            int count=1;
            if(str.charAt(i)!=0){
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(i)==str.charAt(j) && i!=j){
                        count++;
                    }
                }
                if(count>1) result+=str.charAt(i)+" "+count+"\n";
            }
        }
         return result;
    }
    static String removeTheChar(String str, char ch){
        String result="";
        for(int i=0;i<str.length();i++){
            if(str.chatAt(i)==ch){
               result+=str.charAt(i);
            }
        }
        return result;
    }

    static double findMaxAverage(int[] nums, int k) {
        int max_sum=0;
        int current_sum=0;
        for(int i=0;i<k;i++){
           current_sum+=nums[i];
        }
        max_sum=current_sum;
        for(int i=k;i<nums.length;i++){
            current_sum=current_sum+nums[i]-nums[i-k];
            if(current_sum>max_sum){
                max_sum=current_sum;
            }
        }
        return (double)max_sum/k;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int end=0;
        int sum=0;
        int minLenWindow=Integer.MAX_VALUE;
        for(int start=0;start<nums.length;start++){
            sum+=nums[start];
            while(target<=sum){
                minLenWindow=Math.min(minLenWindow,start-end+1);
                sum=sum-nums[end];
                end++;
            }
        }
        return minLenWindow==Integer.MAX_VALUE?0:minLenWindow;
    }
    // another sliding window problem asked in amazon
    public int longestOnes(int[] nums, int k) {
        int maxLength=0;
        int zeroCount=0;
        int start=0;
        for(int end=0;end<nums.length;end++){
            if(nums[end]==0){
                zeroCount++;
            }
            while(zeroCount>k){// shrink the window
                if(nums[start]==0){// reduce the zero count
                    zeroCount--;
                }
                start++;// move the start pointer
            }
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int start=0;
        Set<Character> set=new HashSet<>();
        for(int end=0;end<s.length();end++){
            // shrink the window until we remove the duplicate character from the set
            while(set.contains(s.charAt(end))){
    // remove the character at the start pointer from the set and move the start pointer
                set.remove(s.charAt(start));
                start++;
            }
            // add the current character to the set and update the max length
            set.add(s.charAt(end));
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
    // another approach using map
    public int lengthOfLongestSubstringMap(String s) {
        int maxLength=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int end=0;end<s.length();end++){
            char ch=s.charAt(end);
            if(map.containsKey(ch)){
                // move the start pointer to the next of the same character last found index
                start=Math.max(map.get(ch)+1,start);
            }
            map.put(ch,end);// update the last found index of the character
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
    // another sliding window problem asked in microsoft
    public int characterReplacement(String s, int k) {
        int maxLength=0;
        int maxCount=0;
        int start=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int end=0;end<s.length();end++){
            char ch=s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxCount=Math.max(maxCount,map.get(ch));
            while((end-start+1)-maxCount>k){// shrink the window
                char leftChar=s.charAt(start);
                map.put(leftChar,map.get(leftChar)-1);
                start++;
            }
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
     public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap=new HashMap<>();
        for(int num:nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }
        Queue<Integer> minHeap=new PriorityQueue<>(
            (a,b)->frequencyMap.get(a)-frequencyMap.get(b));
            minHeap.offer(num);
            int[] result=new int[k];
            for(int i=0;i<k;i++){
                result[i]=minHeap.poll();
            }
        return result;
    }
}
