public class LargestGoodInteger {
    public static void main(String[] args){

    }
    static String largestGoodInteger(String num) {
        String max="";
        for(int i=0;i<num.length()-2;i++){
            char ch=num.charAt(i);
            if(ch==num.charAt(i+1) && ch==num.charAt(i+2)){
                String s=num.substring(i,i+3);
                if(s.compareTo(max)>0){
                    max=s;
                }
            }
        }
        return max;
    }
}
