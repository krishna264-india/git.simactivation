public class LengthOfString {
    public static void main(String[] args) {
        
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left=0, right=0, maxLen=0, uniqueChar=0;
        int[] charCount = new int[128];
        while(right<s.length()){
            int rchar=s.charAt(right);
            if(charCount[rchar]==0){
                uniqueChar++;
            }
              charCount[rchar]++;
              right++;
              // If more than 2 unique characters, shrink window
              while(uniqueChar>2){
                int lchar=s.charAt(left);
                charCount[lchar]--;
                if(charCount[lchar]==0){
                    uniqueChar--;
                }
                left++;
              }
             // Only update if exactly 2 unique characters
             if(uniqueChar==2){
                maxLen=Math.max(maxLen,right-left);
             }
        }
        return maxLen;
    }
    
}
