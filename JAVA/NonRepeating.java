public class NonRepeating {
    public static void main(String[] args) {
        String s="abcabc";
        System.out.println(lengthOfLongestSubstring(s));
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
                maxLen=Math.max(maxLen, right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
    static String nonRepeatingCharacters(String str){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(map.get(ch)==1){
                return i;  
            }
        }
        return "";
    }
}
