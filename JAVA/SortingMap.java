import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm= new HashMap<>();
        hm.put("venu", 27);
        hm.put("Gopal Reddy", 56);
        hm.put("krishna", 25);
        hm.put("srikrishna", 10000);
    Map<String,Integer> sortedMap=hm.entrySet()
                                      .stream()
                                      .sorted(Map.Entry.comparingByValue())
                                      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                      (e1, e2)->e1, LinkedHashMap::new));
                                       System.out.println(sortedMap);
    }
    String str="Krishna Reddy";
    charCount(str);
    public static void charCount(String str){
        Map<Character,Integer> map=new HashMap<>();
        char[] ch=str.toCharArray();
        for(char c:ch){
            if(map.contains(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
