import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args){
        String str="111011011";
        System.out.println("Length of longest substring containing '1' = "+maxSubstring(str));
    }
     static int maxSubstring(String s){
        int n=s.length();
        int maxLen=0;

        for(int i=0;i<=n-1;i++){
            if(s.charAt(i)=='1'){
                int count=1;
                for(int j=i+1;
                 j<=n-1&&s.charAt(j)=='1';j++)
                    count++;
                    maxLen=Math.max(maxLen,count);
            }
        }
        return maxLen;
     }
    static int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n<2){
            return n;
        }
        Set<Character> set= new HashSet<>();
        int maxLen=0, left=0, right=0;
        while(right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLen=Math.max(maxLen, right-left+1)
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
    public static int longestKSubstr(String s, int k) {
        Set<String> set=new HashSet<>();
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            set.clear();
            for(int j=i;j<s.length();j++){
                set.add(s.charAt(j));
                if(set.size()==k){
                    maxLen=Math.max(maxLen, j-i+1);
                    break;
                }
            }
        }
        return maxLen;
    }

}
