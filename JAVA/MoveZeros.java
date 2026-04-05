import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

public class MoveZeros {
    public static void main(String[] args){
        int[] arr={0,1,0,3,12};
        String s="PAYPALISHIRING";
        int numRows=4;
        // String result=convert(s,numRows);
        System.out.println(convert(s,numRows));

    }
    public static void moveZeros(int[] arr){
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[count];
                arr[count++]=temp;
            }
        }
    }
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
       return nums[nums.length/2];
        }
        public int mostFrequentEven(int[] nums) {
            int[] count =new int[10000];// assuming max number is 9999
            for(int i=0;i<nums.length;i++){// counting frequency of each number
                count[nums[i]]++;// increment count for each number
            }
            int max=0;
            int maxEven=0;
            for(int i=0;i<10000;i++){
                if(i%2==0 && count[i]>max){
                    max=count[i];
                    maxEven=i;
                }
                if(count[i]>maxEven){
                    maxEven=i;
                }
                }
                return max;
            }
            

        public int removeDuplicates(int[] nums) {
            if (nums.length==0) return 0;
            int i=0;
            for (int j=1;j<nums.length;j++){
                if (nums[j]!=nums[i]){
                    i++;
                    nums[i]=nums[j];
                }
            }
            return i+1;
            }
            public boolean isSubsequence(String s, String t) {
                int i=0,j=0;
                while(i<s.length() && j<t.length()){
                    if(s.charAt(i)==t.charAt(j)){
                        i++;
                    }
                     j++;
                }
                return i==s.length();
            }
            public boolean isPalindrome(String s) {
                s=s.toLowerCase().replaceAll("[^a-z0-9]","");
                int i=0,j=s.length()-1;
                while(i<j){
                    if(s.charAt(i)!=s.charAt(j)){
                        return false;
                    }
                    i++;
                    j--;
                }
                return true;
                }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String first=strs[0];
        String last=strs[strs.length-1];
        int minLength=Math.min(first.length(),last.length());
        int i=0;
        while(i<minLength && first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
      }
      public String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        // StringBuilder sb=new StringBuilder();
        String res="";
         for(int i=words.length-1;i>0;i--){
            res+=words[i]+"";
        //     sb.append(words[i]+" ");
         }
         return res+words[0];
        // return sb.tostring().trim();
      }

      public static String convert(String s, int numRows) {
        if(numRows==1 || s.length()<=numRows){
            return s;
        } 
         // Create an array of StringBuilder objects to represent each row
        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i]=new StringBuilder();
        }
        int index=0;
        boolean isStep=false;
        // Traverse the string and place characters in the appropriate row
        for(char c:s.toCharArray()){
            rows[index].append(c);
            if(index==0 || index==numRows-1){
                isStep=!isStep;
            }

            // if(isStep) index++
            //else index--;
            index+=isStep?1:-1;// Move up or down the rows
        }
         // Combine all the rows to get the final result
         StringBuilder res=new StringBuilder();
         for(StringBuilder row:rows){
            res.append(row);
         }
         // Optionally, print the rows to check the result
    for (StringBuilder row : rows) {
        System.out.println(row.toString());
    }
         return res.toString();
      }

      public void findSecretWord(String[] words, Master master) {
        // The number of guesses allowed is 10 (based on the typical problem constraint)
        int guessesLeft=10;
        // Use a brute-force approach and try to guess the words
        while(guessesLeft>0){
            // Choose a word to guess (could be any word from the list)
            String guess=words[0];
            // Get the number of matches between the guess and the secret word
            int matces=master.guess(guess);
            // If we guessed the secret word correctly (i.e., matches == word length), break
            if(matces==guess.length()){
                break;
            }
            // Filter the list of words to only those that have the same number of matching characters
            List<String> remainingWords=new ArrayList<>();
            for(String word:words){
                if(getMatchCount(guess,word)==matces){
                    remainingWords.add(word);
                }
            }
             // Update words to the filtered list of remaining words
             words=remainingWords.toArray(new String[0]);
             //Decrement the number of guess left
             guessesLeft--;
        }
      }
      private int getMatchCount(String guess,String word){
        int count=0;
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i)==word.charAt(i)){
                count++;
            }
        }
        return count;
      }
      public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
      }
      public long zeroFilledSubarray(int[] nums) {
        // int count=0;
        // int n=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         n++;
        //     }
        //     else{
        //         count= (n*(n+1)/2);
        //         n=0;
        //     }
        //     return count=(n*(n+1)/2);

        int count=0;
        int total_zero=0;
        int prev=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && prev!=0){
                count=1;
                total_zero+=count;
                prev=nums[i];
            }
            else if(nums[i]==0 && prev==0){
                count++;
                total_zero+=count;
                prev=nums[i];
            }else{
                count=0;
                prev=nums[i];
            }
        }
        return total_zero;
        }

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i=m-1;
            int j=n-1;
            int k=m+n-1;
            while(i>=0 && j>=0){
                if(nums1[i]> nums2[j]){
                    nums1[k--]= nums1[i--];
                }
                else{
                    nums1[k--]=nums2[j--];
                }
            }
            while(j>=0){
                nums1[k--]=nums[j--];
            }
            return nums1;
        }
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res =new ArrayList<>();
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(i>0 && nums[i]=nums[i-1]){
                    continue;
                }
                int j=i+1;
                int k=nums.length-1;
                while(l<r){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(sum>0){
                        r--;
                    }
                    else if(sum<0){
                        j++;
                    }
                    else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j<nums.length-1 && nums[j]==nums[j+1]){
                            j++;
                        }
                        while(k>0 && nums[k]==nums[k-1]){
                            k--;
                        }
                        j++;
                        k--;
                    }
                }
            }
            return res;
        }
        public NumArray(int[] nums) {
            
        }
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            // Step 1: Count the frequency of each number
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            // Step 2: Create a priority queue to store the top k frequent numbers
            PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>
            ((a,b)->Integer.compare( b.getValue(),a.getValue()));
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                pq.offer(entry);
            }

            // Step 3: Extract the top k frequent elements from the heap
            int[] res=new int[k];
            for(int i=0;i<k;i++){
                res[i]=Objects.requireNonNull(pq.poll()).getKey();
            }
            return res;
        }
    }

