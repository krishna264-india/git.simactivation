import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseFibonacci {
    public static void main(String[] args) {
        List<Integer> sequence=new ArrayList<>(Arrays.asList(4181, 2684));

        IntStream.range(0, 8).forEach(i->{
             int nxt=sequence.get(sequence.size()-2)-sequence.get(sequence.size()-1)
             sequence.add(nxt);
        });
         // Print the result
        sequence.forEach(System.out::println);

         List<Integer> seq=new ArrayList<>();
         seq.add(4181);
         seq.add(2684);

         int total=10;
         for(int i=2;i<=total;i++){
            int first=seq.get(i-2);
            int last=seq.get(i-1);

            seq.add(first,last);
         }
          // Print the result
        for (int num : seq) {
            System.out.println(num);
        }
 
    }
    
}
