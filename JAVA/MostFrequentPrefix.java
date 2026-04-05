import java.util.HashMap;
import java.util.Map;

public class MostFrequentPrefix {
    public static void main(String[] args) {
        String[] words={
            "apple", "app", "apricot", "apply", "ape", "banana", "bat", "batch"
        };

        Map<Character, Integer> prefixMap = new HashMap<>();
        for(String word:words){
            StringBuilder prefix=new StringBuilder();
            for(char c:word.toCharArray()){
                prefix.append(c);
                String currPrefix=prefix.toString();
                prefixMap.put(currPrefix,prefixMap.getOrDefault(currPrefix,0)+1);
            }
        }

        // Step 3: Find the most frequently occurring prefix
        String MostFrequentPrefix="";
        int maxcount=0;
        for(Map<Character,Integer> entry: prefixMap.entrySet()){
            String prefix=entry.getKey();
            int count=entry.getValue();
            if(count>maxcount || (count==maxcount && prefix.length()> MostFrequentPrefix.length())){
                maxcount=count;
                MostFrequentPrefix=prefix;
            }
        }
        // Step 4: Output the result
        System.out.println("Most Frequently Occurring Prefix: " + mostFrequentPrefix);
        System.out.println("Frequency: " + maxFrequency);
    }
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007; 
        int totalSum=0;
        int evenCount=1;// empty subarray
        int oddCount=0;
        int prefixSum=0;
        for(int num:arr){
            prefixSum+=num;
            if(prefixSum%2==0){
                totalSum=(totalSum+oddCount)%mod;
                evenCount++;
            }
            else{
                totalSum=(totalSum+evenCount)%mod;
                oddCount++;
            }
        }
        return totalSum;
    }
    
}
