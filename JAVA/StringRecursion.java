import java.util.Arrays;
import java.util.List;
public class StringRecursion {
    public static void main(String []args){
        // System.out.println(skip1("ssakkar"));
        // System.out.println(skipNotApple("ssapplekkr"));

        String s="Hello Krishna";
        StringRecursion sr=new StringRecursion();
        System.out.println(sr.lengthOfLastWord(s));


    }
    static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch =='a'){
            skip(p, up.substring(1));

        }else{
            skip(p + ch, up.substring(1));
        }

    }
    static String skip1(String up){
        if(up.isEmpty()){
            //System.out.println(p);
            return "";
        }
        char ch=up.charAt(0);
        if(ch =='a'){
           return skip1(up.substring(1));

        }else{
           return ch + skip1(up.substring(1));
        }

    }
    static String skipApple(String up){
        if(up.isEmpty()){
             return "";
        }
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));

        }else{
            return up.charAt(0)+skipApple(up.substring(1));
        }

    }
    static String skipNotApple(String up){
        if(up.isEmpty()){
             return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipNotApple(up.substring(5));

        }else{
            return up.charAt(0)+skipNotApple(up.substring(1));
        }

    }
    /*
     * Given a string s consisting of words and spaces, 
     * return the length of the last word in the string.
A word is a maximal 
substring
consisting of non-space characters only.
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
     */

    public int lengthOfLastWord(String s) {
        int len=0;
        String x=s.trim();
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)==' '){
               len=0;
            }else{
                len++;
            }

        }
        return len;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] a=new int[26];// a-z
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            a[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(a[i]!=0){
                return false;
            }
        }
        return true;
    }
    public int strStr(String haystack, String needle) {
        // if(needle.length()==0){
        //     return 0;
        // }
        // int len=haystack.length();
        // int len1=needle.length();
        // for(int i=0;i<len;i++){
        //     int j=0;
        //     while(i+j<len && j<len1 && haystack.charAt(i+j)==needle.charAt(j)){
        //         j++;
        //     }
        //     if(j==len1){
        //         return i;
        //     }
        // }
        // return -1;
        int len=haystack.length();
        int len1=needle.length();
        String s=haystack+needle;
        int index=s.indexOf(needle);
        return index;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if(words.length==0 || s.length()==0 || words==null || words.length()==0){
            return res;
        }
        int len=words.length;
        int len1=words[0].length();
        int len2=s.length();
        int[] a=new int[len];
        for(int i=0;i<len;i++){
            a[i]=words[i].length();
        }
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=a[i];
        }
        for(int i=0;i<len1;i++){
            int[] b=new int[len1];
            for(int j=0;j<len;j++){
                if(contains(a,i,j)){
                    b[j]=1;
                    sum-=a[j];
                }
            }
            if(sum==0){
                res.add(i);
            }
        }
        return res;
    }
    public boolean contains(int[] a,int start, int end){
        for(int i=start;i<=end;i++){
            if(a[i]!=1){
                return false;
            }
        }
        return true;
    }
}
