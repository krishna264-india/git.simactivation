import java.util.ArrayList;
import java.util.List;

public class SpriralMatrix {

    public static void main(String[] args) {
        
    }
     public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res= new ArrayList<>();
        if(matrix.length==0) return res;
        int top=0, bottom=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
               res.add(matrix[top][i]);
            }
            top++;
            for(int j=top;j<=bottom;j++){
                res.add(matrix[j][right]);
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
    
}
