public class KNights {
    public static void main(String[] args){
        int n=4;
       boolean[][] board=new boolean[n][n];
       nights(board,0,0,4);
    }
    static void nights(boolean[][] board,int row,int col,int knight){
        if(knight==0){
           display(board);
           System.out.println();
           return;
        }
        if(row==board.length-1 && col==board.length){// last cell
              return;
        }
        if(col==board.length){// last column
          nights(board,row+1,0,knight);// down
          return;
        }
        if(isSafe(board,row,col)){
           board[row][col]=true;
           nights(board,row,col+1,knight-1);
           board[row][col]=false;
        }
        nights(board,row,col+1,knight);

    }
    private static boolean isSafe(boolean[][] board,int row,int col){
        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1]){
            return false;
            }
        }
        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2]){
                return false;
                }
        }
        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1]){
                return false;
                }
        }
        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
                }
        }

        return true;

    }
    static boolean isValid(boolean[][] board,int row,int col){
          if(row>=0 && row<board.length && col>=0 && col<board.length){
                 return true;
          }
          return false;
    }
    private static void display(boolean[][] board){
        for(boolean[] row:board){
         for(boolean element:row){
              if(element){
                 System.out.print("K");
              }else{
                 System.out.print("X");
              }
         }
         System.out.println();
        }
        
 }
}
