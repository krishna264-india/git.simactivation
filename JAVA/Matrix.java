import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
    public static void main(String[] args){
        int[][] arr={{20,30,47,48},
                     {34,45,67,90},
                     {87,65,43,23}};
                     System.out.println(Arrays.toString(matrix(arr,67)));
    }
    /*
        * Search in a 2D Matrix
        * Time Complexity: O(n*m)
        * Space Complexity: O(1)
        * Not a Stable Sorting Algorithm
        * Not an In-Place Sorting Algorithm
     */
    static int[] matrix(int[][] arr,int target){
       
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr[r].length;c++){
                if(arr[r][c]==target){
                    return new int[] {r,c};
                }

            }
            
        }
        return new int[] {-1,-1};
        

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Intger> res=new ArrayList<>();
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
         return res;
}
 public void rotate(int[][] matrix) {
    int n=matrix.length;
    for(int i=0; i<n+1/2;i++){
        for(int j=0;j<n/2;j++){
            int temp=matrix[n-1-j][i];
            matrix[n-1-j][i]=matrix[n-1-i][n-j-1];
            matrix[n-1-i]matrix[n-j-1]=matrix[j][n-1-i];
            matrix[j][n-1-i]=matrix[i][j];
            matrix[i][j]=temp;
        }
    }
    }
}
