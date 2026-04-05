public class FindChar{
  /*
   * Given a list of sorted characters letters containing only lowercase letters,
   * and given a target letter target, find the smallest element in the list that is
   * greater than the target.
   */
    public static void main(String[] args){
       char[] letters={'c','f','j','q'};
       char target='h';
       System.out.println(charLetters(letters,target));
    }
    static char charLetters(char[] letters,char target){
           int start=0;
           int end=letters.length-1;

           while(start<=end){
               int mid=start+(end-start)/2;
               if(target<letters[mid]){
                end=mid-1;

               }else{
                 start=mid+1;
               }
           }
           return letters[start%letters.length];
    }
}