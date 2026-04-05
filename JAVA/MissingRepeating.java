import java.util.ArrayList;

public class MissingRepeating {
    public static void main(String[] args) {
        MissingRepeating mr = new MissingRepeating();
        int arr[] = {3, 1, 3};
        ArrayList<Integer> result = mr.findTwoElement(arr);
        System.out.println("Missing number: " + result.get(0));
        System.out.println("Repeating number: " + result.get(1));
        
    }
    static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        // Create a count array to store the frequency of each number
        int[] count = new int[n + 1];
        for (int num:arr) {
            count[num]++;// frequency count
        }
        int missing = -1, repeating = -1;
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {// Missing number
                missing = i;
            } else if (count[i] > 1) {// Repeating number
                repeating = i;
            }
        }
        result.add(missing);
        result.add(repeating);
        return result;
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int total=n*n;
        int[] count=new int[total+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                count[grid[i][j]]++;    
            }
        }
        int missing=-1,repeating=-1;
        for(int i=1;i<=total;i++){
            if(count[i]==2) repeating=i;
            else if(count[i]==0) missing=i;
        }
        return new int[]{repeating,missing};
    }
}
