public class TrailingOfZero {
    public static void main(String[] args){
        String s="532104000";
        int len=s.length();
        int count=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)!='0'){
                break;
            }
            else{
                count++;
            }
        }
        System.out.println(count);
                // System.out.println(s.substring(0,i+1));
                // System.exists(0);
            }
        }
