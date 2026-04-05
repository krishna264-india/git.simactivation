import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeparatesAllNumbers {
    public static void main(String[] args) {
        String str="abc123";
        var partition=IntStream.range(0,str.length())
                      .mapToObj(str::charAt)
                      .collect(Collectors.partitioningBy(Character::isDigit,
                        Collectors.mapping(String::valueOf, Collectors.joining())));
                 System.out.println("Alphabets: " + partition.get(false));
                 System.out.println("Numbers: " + partition.get(true));
    }
}
