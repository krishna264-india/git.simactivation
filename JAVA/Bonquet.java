import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bonquet {
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>(Arrays.asList(8, 3, 6, 7, 2, 9, 5));
            int num = arr.size(), random = 3;

            List<Integer> result = arrangeFlowerSticks(num, random, arr);
            System.out.println(result);
            
        Scanner sc= new Scanner(System.in);
        // Read number of flowers
        int n=sc.nextInt();
        // Read the number of flowers in each bouquet
        int[] flowerStem=new int[n];
        for(int i=0;i<n;i++){
            flowerStem[i]=sc.nextInt();
        }
        // Read the number of boquet
        int k=sc.nextInt();
        // Sort the first K flowers in increasing order
        Arrays.sort(flowerStem,0,k);
        // Sort the remaining N-K flowers in decreasing order
        Arrays.sort(flowerStem,k,n);
        reverse(flowerStem,k,n-1);
        // Print the first K elements
        for(int i=0;i<k;i++){
            System.out.print(flowerStem[i]+" ");
        }
        System.out.println();
        // print the remaining n-k elements
        for(int i=k;i<n;i++){
            System.out.print(flowerStem[i]+" ");
        }
        sc.close();
    }
    private static void reverse(int[] arr, int start, int end) {
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static List<Integer> arrangeFlowerSticks(int num, int random, List<Integer> arr) {
            // Create new lists to avoid modifying sublist views
            List<Integer> firstPart = new ArrayList<>(arr.subList(0, random));
            List<Integer> secondPart = new ArrayList<>(arr.subList(random, num));

            // Sort first K elements in ascending order
            Collections.sort(firstPart);

            // Sort remaining elements in descending order
            secondPart.sort(Collections.reverseOrder());

            // Merge both parts
            List<Integer> result = new ArrayList<>();
            result.addAll(firstPart);
            result.addAll(secondPart);

            return result;
        }
}
