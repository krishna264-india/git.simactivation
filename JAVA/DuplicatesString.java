import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicatesString {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("venu", "Krishna", "venu", "Gopalreddy");
        System.out.println("Original List:" + names);
        String s="Swiss";
        String exclude="i";

        String[] str= {"venu", "Krishna", "venu", "Gopalreddy"};

        Set<String> duplicates= new HashSet<>();
        List<String> result=str.stream(str).filter(t->!duplicates.add(t))
                               .distinct()
                               .collect(Collectors.toList());
            System.out.println(result);

            System.out.println("======================================================");

            //duplicates
            int a[] ={2,3,4,9};
            int b[]={2,3,7};
            int c[]= {2,3,1};

            List<Integer> list1=IntStream.of(a).boxed().collect(Collectors.toList());
            List<Integer> list2= IntStream.of(b).boxed().collect(Collectors.toList());
            List<Integer> list3= IntStream.of(c).boxed().collect(Collectors.toList());
              List<Integer> result= list1.stream()
                .filter(list2::contains)
                .filter(list3::contains)
                .distinct()
                .collect(Collectors.toList());

               System.out.println(result);
            System.out.println("--------------------------------------------------------");
            
        Map<Character,Integer> freq=new HashMap<>();
        for(char ch:s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        for(char ch:s.toCharArray()){
            if(freq.get(ch)==1 && ch!=exclude){
                System.out.println(ch);
            }
        }


        for (String name : names) {
            if (names.indexOf(name) != names.lastIndexOf(name)) {
                System.out.println(name);
            }
        }

        // Set<String> duplicates=names.stream()
        // .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        // .entrySet()
        // .stream()
        // .filter(entry-> entry.getValue()>1)
        // .map(Map.Entry::getKey)
        // .collect(Collectors.toSet());

        Set<String> seen = new HashSet<>();
        for (String name : names) {
            seen.add(name);

            System.out.println(name);
        }

        // Set<String> duplicates = names.stream()
        // .map(String::toLowerCase)
        // .filter(t -> !seen.add(t))
        // .collect(Collectors.toSet());
        // System.out.println("Duplicates (ignore case): " + duplicates);

        Set<String> duplicates = names.stream()
                .filter(t -> !seen.add(t))
                .distinct()
                .collect(Collectors.toSet());
        System.out.println("Duplicates:" + duplicates);

    }
    public char uniqueChar(String s){
        Map<Character,Integer> map= new HashMap<>();
        for(char ch:s.toCharArray()){
          map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return '0';// no unique character
    }
    public static Set<Character> findDuplicateChars(String input) {
    Set<Character> seen = new HashSet<>();
    return input.chars()
         .mapToObj(c -> (char) c)
         .filter(ch -> !seen.add(ch))// duplicates: add() returns false for any repeat
         .collect(Collectors.toSet());
} 

}
