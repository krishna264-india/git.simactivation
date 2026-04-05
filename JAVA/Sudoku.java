import java.util.*;
public class Sudoku {
    public static void main(String[] args){
        int[][] board=new int[][]{
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };
              System.out.println(solve(board));
    }
    static boolean solve(int[][] board){
        int n=board.length;
        int row=-1;
        int col=-1;
   
         boolean emptyLeft=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                   row=i;
                   col=j;
                   emptyLeft=false;
                   break;
                }
            }
            if(emptyLeft==false){// if we found an empty cell
                break;
            }

        }
        if(emptyLeft==true){
             return true;
        }

        for(int number=0;number<9;number++){// try each number from 1 to 9 
             if(isSafe(board,row,col,number)){// if the number is safe to place 
                board[row][col]=number;// place the number
                if(solve(board)){// if the board is sloved 
                    display(board);
                   return true;
                }else{
                    board[row][col]=0;
                }

             }
        }
        return false;

    }
    static void display(int[][] board){
        for(int[] row:board){
            for(int num:row){
                   System.out.print(num+" ");
            }
            System.out.println();
        }
        

    }
    static boolean isSafe(int[][] board,int row,int col,int num){
        //check the row
        for(int i=0;i<board.length;i++){
            if(board[row][col]==num){
                 return false;
            }

        }
        //check the col
        for(int[] nums:board){
           if( nums[col] == num){
              return false;
           }
        }
        // check the box
        int sqrt=(int)(Math.sqrt(board.length));
        int rowStart=row-row % sqrt;
        int colStart=col-col % sqrt;
        for(int r=rowStart;r<rowStart +sqrt;r++){
            for(int c=colStart;c<colStart +sqrt;c++){
                if(board[r][c] == num){
                    return false;
                }

            }

        }
        return true;

    }

//     static boolean isValidSudokodu(int[][] board){
//         Set<Integer>[] rows=new HashSet[9];
//         Set<Integer>[] cols=new HashSet[9];
//         Set<Integer>[] boxes=new HashSet[9];
//         for(int i=0;i<9;i++){
//             rows[i]=new HashSet<>();
//             cols[i]=new HashSet<>();
//             boxes[i]=new HashSet<>();
//         }
//         for(int row=0;row<9;row++){
//             for(int col=0;col<9;col++){
//                 int num=board[row][col];
//                 if(num==0){
//                     continue;
//                 }
//                 if(rows[row].contains(num)) return false;
//                 rows[row].add(num);
//                 if(cols[col].contains(num)) return false;
//                 cols[col].add(num);
//                 int boxIndex= (row/3)*3 + (col/3);
//                 if(boxes[boxIndex].contains(num)) return false;
//                 boxes[boxIndex].add(num);
//             }
//         }
//         return true;
// }
}
