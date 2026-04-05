import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        
    }
    static boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()) return false;

        char[] arr1=s1.toLowerCase().toCharArray();
        char[] arr2=s2.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }

    static boolean isAnagram2(String s1,String s2){

        Map<Character,Integer> map1= s1.chars()
                                      .mapToObj(c->(char)c)
                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character,Integer> map2=s2.chars()
                                      .mapToObj(c->(char)c)
                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                                      return map1.equals(map2);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to hold lists of anagrams
        Map<String,List<String>> map=new HashMap<>();
        Arrays.sort(strs);
        // Iterate through each string in the input array
        for(String str:strs){
            char[] charArray=str.toCharArray();
            Arrays.sort(charArray);
            // Create a new string from the sorted character array
            String sorted=new String(charArray);
            map.putIfAbsent(sorted, new ArrayList<>());// initialize list if key not present
            // Add the original string to the list corresponding to the sorted key
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
        // return Arrays.stream(strs)
        //               .collect(Collectors.groupingBy(
        //                 s-> {
        //                     char[] arr=s.toCharArray();
        //                     Arrays.sort(arr);
        //                     return new String(arr);
        //                 }
        //               ))
        //               .values()
        //               .stream()
        //               .collect(Collectors.toList());
    }

    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> res=new ArrayList<>();
         if(p.length()>s.length()) return res;
         
        //  Map<Character,Integer> map= new HashMap<>();
        //  for(char c:p.toCharArray()){
        //     map.put(c,map.getOrDefault(map,0)+1);
        //  }
        //  int left=0,right=0;
        //  int count =p.length();
        //  while(right<s.length()){
        //     char c=s.charAt(right);
        //     if(map.getOrDefault(c,0)>0){
        //         count--;
        //         right++;
        //     }
        //     map.put(c,map.getOrDefault(c,0)-1);
        //     if(count==0){
        //         res.add(left);
        //     }
        //     if(right-left==p.length()){
        //         char lc=s.charAt(left);
        //         if(map.getOrDefault(lc,0)>=0){
        //             count++;
        //         }
        //         map.put(lc,map.getOrDefault(lc,0)+1);
        //         left++;
        //     }
        //  }

        int[] pCount=new int[26];
        int[] windowCount=new int[26];
        for(char c:p.toCharArray()){
            pCount[c-'a']++;
        }  
        int windowSize=p.length();
        for(int i=0;i<s.length();i++){
            windowCount[s.charAt(i)-'a']++;
            if(i>=windowSize){
                windowCount[s.charAt(i-windowSize)-'a'];
            }
            if(Arrays.equals(pCount,windowCount)){
                res.add(i-windowSize+1);
            }
        }
         return res;
    }
}

