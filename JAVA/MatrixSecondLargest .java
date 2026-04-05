import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixSecondLargest  {
    public static void main(String[] args) {
        int[][] matrix={  {10, 3, 5,  6},
                          {7,  2, 9,  4},
                          {8, 11, 1, 12}}
      
            System.out.println("Sum = " + sumSecondLargestHalves(matrix));
        int[] input = {1, 2, 11, 21, 31, 42, 56, 23, 16};
        List<String> result = findElementsStartingWithOne(input);
             System.out.println(result);
    public static int sumSecondLargestHalves(int[][] matrix) {
                int cols=matrix[0].length;
                int split=cols/2;
                Integer secondLargestLeft = Arrays.stream(matrix)
                                            .flatMapToInt(row-> IntStream.range(0, split).map(i->row[i]))
                                            .distinct()
                                            .boxed()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst()
                                            .orElseThrow(() -> new NoSuchElementException("Left half needs >= 2 distinct values"));
                Integer secondLargestRight =Arrays.stream(matrix)
                                            .flatMapToInt(row-> IntStream.range(cols, split).map(i->row[i]))
                                            .distinct()
                                            .boxed()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst()
                                            .orElseThrow(() -> new NoSuchElementException("Right half needs >= 2 distinct values"));
                                return secondLargestLeft+secondLargestRight;
    }

    public static List<String> findElementsStartingWithOne(int[] numbers) {
        return Arrays.stream(numbers)
                     .boxed()
                     .map(String::valueOf)
                     .filter(str->str.startsWith("1"))
                     .collect(Collectors.toList());
    }
                                      
    }
}
