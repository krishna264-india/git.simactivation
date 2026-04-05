public class RemovePair {
    public static void main(String[] args) {
         String s= 
    }
    public int maximumGain(String s, int x, int y){
        if(x>y) return gain(s,"ab",x,"ba",y);
        else{
            return gain(s,"ba",y,"ab",x);
        }
    }
    private int gain(String s,String firstPair,int firstScore,
    String secondPair, int secondScore){
    
        StringBuilder sb=new StringBuilder();
        int totalScore=0;
        for(char ch:s.toCharArray()){
            int len=sb.length();
            if(len>1 && sb.charAt(len-1)==firstPair.charAt(0) && ch==firstPair.charAt(1)){
                sb.setLength(len-1);// remove last two characters
                totalScore+=firstScore;
            }
            else{
                sb.append(ch);
            }
        }
        int len=0;
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(len>1 && sb.charAt(len-1)==secondPair.charAt(0) && ch==secondPair.charAt(1)){
                len--;
                totalScore+=secondScore;
            }
            else{
                sb.setCharAt(len++, ch);
            }
        }
        sb.setLength(len);
        return totalScore;
    }
    
}
