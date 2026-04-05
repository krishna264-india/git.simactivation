public class SearchInString {
    public static void main(String[] args) {
        String name="krishna";
        char c='s';
        System.out.println(search(name,c));
    }
    static boolean search(String str,char c){
        if(str.length()==0){
            return false;

        }
        for(int i=0;i<str.length();i++){
            if(c==str.charAt(i)){
                return true;

            }

        }
        return false;

    }

}
