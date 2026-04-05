import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Palindrom implements Palindrom {
    public static void main(String[] args){

        String input="madam";
        String reversed=IntStream.range(0, input.length())
        .mapToObj(i->String.valueOf(input.charAt(input.length()-i)))
        .collect(Collectors.joining());

        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
        System.out.println("-------------------------------");
        
        Scanner sc=new Scanner(System.in);
           System.out.println("enter first number");
           int a=sc.nextInt();
           System.out.println("enter second number");
           int b=sc.nextInt();
           if(a!=0 && b!=0){ 
            System.out.println("none of them can't be zero");
           }  
           //so checking the condition     
            if(a>=b && a==b){
                System.out.println("program will be terminated");
                return;
            }
            else{
                System.out.println("program will be continued");
           }
        
          for(int i=a;i<=b;i++){
            if(isPalindrome(i)){
            System.out.print(i+" ");
            }

          }
        }
        public static boolean isPalindrome(int num){
            int temp=num;
            int rev=0;
           while(num!=0){
            int rem=num%10;
            rev=rev*10+rem;
            num=num/10;
           }
            return temp==rev;
        }

        public static String FindLongestPalindrome(String s){
            int n=s.length();
            return IntStream.range(0, n)
                   .boxed()
                   .flatMap(i->IntStream.rangeClosed(i+1,n))
                   .mapToObj(j->s.substring(i,j))
                   .filter(LongestPalindrome::isPalindrome)
                   .max((a,b)-> Integer.compare(a.length(), b.length()))
                   .orElse("");
        }
         @Override
        public String longestPalindrome(String s) {
            int n=s.length();
            String res="";
            int maxLen=0;
            for(int i=0;i<n;i++){
                for(int j=1;j<n;j++){
                    if(isPalindrome(s,i,j) && j-i+1>maxLen){
                        maxLen=j-i+1;
                        res=s.substring(i,j+1);
                    }
                }
            }
            return res;
         }
        private static boolean isPalindrome(String str){
            return str.equals(new StringBuilder(str).reverse().toString());
        }
        public static boolean isPalindrome(String original) {
          String s = original.replaceAll("\\s+", "").toLowerCase();
          return IntStream.range(0, s.length() / 2)
                    .noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
}

    private boolean isPalindrome(String s,int start,int end){
		while(start<end){
			if(s.charAt(start)!=s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
    public String longestPalindrome1(String s) {
        int n=s.length();
        int start=0, end=0;
        for(int i=0;i<n;i++){
            int len1=expandFromCenter(s,i,i);// odd length palindrome
            int len2=expandFromCenter(s,i,i+1);// even length palindrome    
            int len=Math.max(len1,len2);
            if(len>end-start){// found a longer palindrome
                start=i-(len-1)/2;// calculate new start index
                end=i+len/2;// calculate new end index
            }
        }
        return s.substring(start,end+1);
    }
    private int expandFromCenter(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
     public boolean validPalindrome(String s) {
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                // skip either left or right character and check for palindrome
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
