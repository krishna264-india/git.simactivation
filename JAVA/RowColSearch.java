/*
 * You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
 */

 // Search a 2D Matrix
//  m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
public class RowColSearch {
    public static void main(String[] args){
        int[][] nums={{1,3,5,7},
                       {10,11,16,20},
                       {23,30,34,60}

        };
        int target=3;
        boolean[] ans=searchMatrix(nums,target);
        System.out.print(ans);
      
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=0;
        int c=matrix[0].length;
        while(r<matrix.length && c>0){
              if(matrix[r][c]==target){
                return true;

              }
               if(matrix[r][c]<target){
                 r++;
              }else{
                c--;
              }
        }
        return false;
    }
}
