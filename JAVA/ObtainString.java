public class ObtainString {
    public boolean canChange(String start, String target) {
        
        int i=0,j=0;
        int m=start.length();// length of start
        int n=target.length();// Length of target
        while(i<m && j<n){ //  Lopp through the string
            char a=start.charAt(i); //  ASCI value of start string
            char b=target.charAt(j);
            if(a=="_" && b=="_"){ 
                i++;j++;
            }
            else if(a=="_"){
                i++;
            }else if(b=="_"){
                j++;
            }
            else if( a==b 
                     && (a=="L" &&i>=j ||
                         b=="R" && i<=j)){
                            i++;j++;

            }else{
                return false;
            }
            while(i<m && start.charAt(i)=="_"){
                   i++;
            }
            while(j<n && target.charAt(j)=="_")
                   j++;
        }
        return i==m && j==n;

    }
}
