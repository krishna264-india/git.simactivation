//search in 2D matrixSearchInSortArray by using binary search
import java.util.Arrays;

public class MatrixSearchInSort {
    public static void main(String[] args){
        int[][] matrix={{2,5,6,8},
                        {10,12,16,18},
                        {24,26,28,30}};
        
        System.out.println(Arrays.toString(search(matrix,12)));

    }
    static int[] binarySearch(int[][] matrix,int row,int cstart,int cend,int target){
        while(cstart<=cend){
            int mid=cstart+(cend-cstart)/2;
            if(matrix[row][mid]==target){
                return new int[]{row,mid};
            }
            if(matrix[row][mid]<target){
                cstart=mid+1;

            }
            else{
                cend=mid-1;
            }

        }
        return new int[]{-1,-1};


    }
    static int[] search(int[][] matrix,int target){
        int row=matrix.length;
        int col=matrix[0].length;
        if(row == 1){
          return binarySearch(matrix,0,0,col-1,target);
        }
         int rstart=0;
         int rend=row-1;
         int cmid=col/2;
         while(rstart<=rend){
            int mid=rstart+(rend-rstart)/2;
            if(matrix[cmid][mid]==target){
               return new int[]{cmid,mid};
            }
            if(matrix[cmid][mid]<target){
                rstart=mid;
            }
            else{
                rend=mid;
            }
         } 
               // we have 2 rows
               //check weather target is in the col of 2
               if(matrix[rstart][cmid]==target){
                return new int[] {rstart,cmid};

               }
               if(matrix[rstart+1][cmid]==target){
                  return new int[] {rstart+1,cmid};
               }
               //search in\ 1st half
               if(target<=matrix[rstart][cmid-1]){
                    return binarySearch(matrix,rstart,0,cmid-1,target);
               }
               //search in\ 2nd half
               if(target>=matrix[rstart][cmid+1] && target<=matrix[rstart][col-1]){
                    return binarySearch(matrix ,rstart,cmid+1,col-1,target);
               }
               //search in\ 3rd half
               if(target<=matrix[rstart+1][cmid-1]){
                return binarySearch(matrix ,rstart+1,0,col-1,target);
               }
               else{
                return binarySearch(matrix ,rstart+1,cmid+1 ,col-1,target);
               }

    }
    
}
