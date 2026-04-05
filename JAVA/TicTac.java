import java.util.Scanner;

public class TicTac {
    public static void main(String[] args){
        char[][] board = new char[4][4];
        for(int row =0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                  board[row][col]=' ';
        }
    }
    char player='X';// player X start first
    boolean gameOver=false;// game is not over yet
    Scanner sc=new Scanner(System.in);

    while(!gameOver) {

        printBoard(board);// display the baord
        System.out.println("Player "+player+"enter: ");// prompt player to enter the move
        int row=sc.nextInt();
        int col=sc.nextInt();
        System.out.println();
         if(board[row][col]==' '){// if the cell is Empty
            board[row][col]=player;// player's move
            if(checkWin(board,player)){// check if player has won
                System.out.println("Player "+player+" wins!");
            }else{
                // if(player=='X'){
                //     player='O';
                // }else{
                //     player='X';
                // }
                player=(player=='X')?'O':'X';
            }
         }else{
            System.out.println("Invalid Move try again!");
         }
        }
         printBoard(board);
    }
    private static boolean  checkWin(char[][] board,char player){
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
              return true;
            }
          }
      
          // check for col
          for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
              return true;
            }
          }
      
          // diagonal
          if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
          }
      
          if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
          }
          return false;
    }
    public static void printBoard(char[][] board){
        for(int row =0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+"|");
            }
                System.out.println();
        }
    }
    }


