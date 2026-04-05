import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperation {
    public static void main(String[] args) {


        List<Integer> numbers= Arrays.asList(3,4,5,4,5,6,7);
        Set<Integer> seen= new LinkedHashSet<>();

        Optional<Integer> firstDuplicate= numbers.stream()
                                        .filter(n->!seen.add(n))
                                        .findFirst();
                                System.out.println(firstDuplicate.get());

System.out.println("---------------------------------------------------------------");

// frquency of each character 
     String str= "Hello World";
     Map<Character,Long> frequency= str.chars().filter(c->c!=' ')
     .mapToObj(c-> (char)c)
     .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new , Collectors.counting()));
     System.out.println(frequency);

     System.out.println("---------------------------------------------------------------");
     
          List<String> names=Arrays.asList("venu","Krishna","murali","ananth");
          List<String> filterNames=names.stream()
                                  .filter(name->name.startsWith("ve"))
                                  .collect(Collectors.toList());
        System.out.println(filterNames);

        List<String>filteStrings=names.stream()
                                 .map(Name->Name.toUpperCase())
                                 .collect(Collectors.toList());
                                 System.out.println(filteStrings);
        
        List<Integer> NumList=Arrays.asList(2,4,2,6,8,10,10,12);
        List<Integer> findIntegers=NumList.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
                                    System.out.println(findIntegers);

        List<String> sortNames=names.stream()
                                     .sorted()
                                     .collect(Collectors.toList());

            System.out.println(sortNames);

    record Post(String title, List<String> tags){

    }
    List<Post> posts=Arrays.asList(
          new Post("Java Basics", List.of("Core Java","Spring Boot","Web"),
          new Post("React guide", List.of("javascript","react", "frontend")),
          new Post("Java", List.of("java8","Springboot","backend")))
    );
    Map<String, List<String>> collect=posts.stream()
                        .flatMap(post->post.tags().stream().map(tag->Map.entry(tag,post.title())))
                        .collect(Collectors.groupingBy(
                            Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue,Collectors.toList())
                        ));
    }


    
}
