public class Stringatio {

    public static void main(String[] args) {
        String s="1337c0d3";
        System.out.println(stringToint(s));
        
    }
     public int myAtoi(String s) {
        int i=0;
        int sign=1;
        int result=0;
        // discard whitespaces
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        // sign check
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if(s.charAt(i)=='+'){
                sign=1;
            }else{
                sign=-1;
            }
            // sign=s.charAt(i)=='+'?1:-1;
            i++;
        }
        // convert number and avoid overflow
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            // check overflow
            if(result> (Integer.MAX_VALUE - digit)/10){// overflow
                return sign==1? Integer.MAX_VALUE: Integer.MIN_VALUE;// return max or min value
            }
            result=result*10 + digit;
            i++;
        }
        return result*sign;
    }
    public static int stringToint(String s){
        int num=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch<'0' || ch>'9'){
                break;
            }
            int digit=ch-'0';
            num=num*10 + digit;
        }
        return num;
    }
} 