import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Frequency {
    public static void main(String[] args){
          String input = "hello world java programming";
          input= input.replaceAll("\\s+","").toLowerCase();
          Map<Character,Integer> frequency= new HashMap<>();
          for(char c:input.toCharArray()){
            frequency.put(c,frequency.getOrDefault(c,0)+1)
          }

          for(Map<Character,Integer> entry: frequency.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
          }
          char maxfreq='';
          char maxchar='';
          for(Map<Character,Integer> entry: frequency.entrySet()){
            if(entry.getValue()>maxfreq){
                maxfreq=entry.getValue();
                maxchar=entry.getKey();
            }
          }
          System.out.println("\nMost Frequent Character: '" + maxChar + "' appears " + maxFreq + " times.");

          int[] fre=new int[26];
          for(char ch:input.toCharArray()){
            if(ch>='a' && ch<='z'){
                fre[ch-'a']++;
            }
          }
          for(int i=0;i<26;i++){
            if(fre[i]>0){
                System.out.println((char)(i+'a')+ " : " + freq[i]);
            }
          }
          char maxfrq='';
          char maxchar='';
          for(int i=0;i<26;i++){
            if(fre[i]>maxfrq){
                maxfrq=fre[i];
                maxchar=(char)(i+'a');
            }
          }
          System.out.println("\nMost Frequent Character: '" + maxChar + "' appears " + maxFreq + " times.");
    }
    
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int start=0, max=0;
        for(int end=0;end<s.length();end++){
            if(!set.contains(s.charAt(end))){
              set.add(s.charAt(end));
              max=Math.max(max,right-left+1);  
            }
            else{
                set.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return max;
    }
    public static int nonRepeatingCharacter(String s){
        Map<Character,Integer> freq=new HashMap<>();
        for(char ch:s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        for(char ch:s.toCharArray()){
            if(freq.get(ch)==1){
                return s.indexOf(ch);
            }
        }
        return -1;
    }  
}
