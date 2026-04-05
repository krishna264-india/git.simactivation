import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args){
        List<Integer> list=Arrays.asList(10,11,12,10,23,109,12);
        list.stream(). distinct().forEach(System.out::println);
        System.out.println("-----------------------");
        list.stream(). sorted(Integer::compare).forEach(System.out::println);

    }
}
