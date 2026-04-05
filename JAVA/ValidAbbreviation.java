public class ValidAbbreviation {
    public static void main(String[] args) {
        String p= "internationalization";
        String s= "a123c45go6";
        System.out.println( validAbbreviation(p,s));
        
    }
    static boolean validAbbreviation(String p ,String s){
         int i = 0, j = 0;
 while (i < p.length() && j < s.length()) {
        if (!Character.isDigit(s.charAt(j))) {
           if (p.charAt(i++) != s.charAt(j++)) return false;
            } else {
                 if (s.charAt(j) == '0') return false;
                      int num = 0;
                     while (j < s.length() && Character.isDigit(s.charAt(j))) {
                     num = num * 10 + s.charAt(j++) - '0';
           }
          i += num;
     }
   }
       return i == p.length() && j == s.length();
    }
    
}
