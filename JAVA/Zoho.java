import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Zoho {
    public static void main(String[] args) {
        
        int[] arr={1,2,2,3,4,4,4,5,5,5,5};
        int ans=findLucky(arr);
        System.out.println(ans);
    }
    /*Problem Statement
    1394. Find Lucky Integer in an Array
    Given an array of integers arr, a lucky integer is an integer which has a frequency in
    the array equal to its value.
    Return the largest lucky integer in the array. If there is no lucky integer return -1.
    ✅ Example
Input: arr = [2,2,3,4]
Output: 2
Input: arr = [1,2,2,3,3,3]
Output: 3

     */
    static int findLucky(int[] arr){
        int max=0;
        for(int num: arr){
            if(num>max){
                max=num;
            }
        }
        // frequency array
        int[] freq=new int[max+1];
        // count frequency
        for(int num:arr){
            freq[num]++;
        }
        // find the largest lucky number
        int lucky=-1;
        for(int i=1;i<freq.length;i++){
            if(freq[i]==i){
                lucky=Math.max(lucky,i);
            }
        }
        return lucky;
    }
    /*Problem Statement
    925. Long Pressed Name
      Given two strings name and typed, check whether typed is a valid long-pressed version
       of name.
      ✅ Example

Input:
name = "alex"
typed = "aaallexx"

Output:
true

Input:
name = "alex"
typed = "alleexxu"

Output:
false
     */
    static boolean isLongPressedName(String name,String typed){
        int i=0;// pointer for name
        int j=0;// pointer for typed
        while(j<typed.length()){// traverse both strings
            if(i<name.length() && name.charAt(i)==typed.charAt(j)){// characters match
                i++;
                j++;
            }
            else if(j>0 && typed.charAt(j)==typed.charAt(j-1)){// long press detected
                j++;
            }
            else{
                return false;
            }
        }
        return i==name.length();
    }
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet=new HashSet<>(Arrays.asList(deadends));// deadends set for quick lookup
        Queue<String> queue=new LinkedList<>();// BFS queue
        Set<String> visited=new HashSet<>();
        String start="0000";
        if(deadSet.contains(start)){
            return -1;
        }
        queue.offer(start);
        visited.add(start);
        int moves=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String curr=queue.poll();
                if(curr.equals(target)){
                    return moves;
                }
                for(String next: getNextStates(curr)){
                    if(!deadSet.contains(next) && !visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private List<String> getNextStates(String state){
        List<String> nextStates=new ArrayList<>();
        char[] chars=state.toCharArray();
        for(int i=0;i<4;i++){
            char originalChar=chars[i];
            // move up
            chars[i]=originalChar=='9' ? '0' : (char)(originalChar+1);
            nextStates.add(new String(chars));
            // move down
            chars[i]=originalChar=='0' ? '9' : (char)(originalChar-1);
            nextStates.add(new String(chars));
            // restore original character
            chars[i]=originalChar;
        }
        return nextStates;
    }
    public int addDigits(int num) {
        if(num<10) return num;// base case
        return 1+(num-1)%9;// digital root formula

        // int sum=0;
        // while(num>0){
        //     sum+=num%10;
        //     num/=10;
        // }
        // if(sum<10) return sum;
        // return addDigits(sum);
    }
    private int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
