package DynamicPrograming;

public class Palindrome {
    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindromeDP(s)); // Expected output: "aba" or "bab"
        
    }
    static String longestPalindromeDP(String s){
        if(s==null || s.length()<1) return "";
        int n=s.length();
        int end=0,start=0;// to keep track of the starting and ending index of the longest palindrome
        for(int i=0;i<n;i++){
            int len1=expand(s,i,i); // odd length palindrome
            int len2=expand(s,i,i+1); // even length palindrome
            int len=Math.max(len1,len2);
            // if the length of the palindrome is greater than the current longest palindrome, update the start and end indices
            if(len>end-start){
                start=i-(len-1)/2;// calculate the starting index of the palindrome
                end=i+len/2;// calculate the ending index of the palindrome
            }
        }
        return s.substring(start,end+1);
    }
    private static int expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1; // length of the palindrome
    }
}
