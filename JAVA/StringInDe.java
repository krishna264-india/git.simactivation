public class StringInDe {
    public static void main(String[] args) {
        
    }
    public String sortString(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        while(sb.length()<s.length()){
            //ascending order
            for(int i=0;i<25;i++){
                if(freq[i]>0){
                    sb.append((char)(i+'a'));
                    freq[i]--;
                }
            }
            // descending order
            for(int i=25;i>=0;i--){
                if(freq[i]>0){
                    sb.append((char)(i+'a'));
                    freq[i]--;
                }
            }
        }
        return sb.toString();
    }
}
