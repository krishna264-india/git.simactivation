import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct {
    public static void main(String[] args) {
        String s="acbdabc";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
    static int lengthOfLongestSubstringTwoDistinct(String s){
        int left=0,maxLen=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int right =0;right<s.length();right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0)+1);

            // Shrink window until it has at most 2 distinct characters
            while(map.size()>2){
                char leftChar=s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0) map.remove(leftChar);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;

    }
    
}
