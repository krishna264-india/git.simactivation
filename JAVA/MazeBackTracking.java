import java.util.Arrays;
public class MazeBackTracking {
    public static void main(String[] args){
        boolean[][] board={{true,true,true},
                           {true,true,true},
                           {true,true,true}};

                       //    allPath("",board,0,0);
        int[][] path=new int[board.length][board[0].length];
        allPathPrint("",board,0,0,path,1);

    }
    static void mazeRestriction(String p,boolean[][] Maze,int r ,int c){
        if(r==Maze.length-1 && c==Maze[0].length-1){
          System.out.println(p);
          return;
        }
        if(!Maze[r][c]){
           return;
        }
        if(r<Maze.length-1){
            mazeRestriction(p+'d',Maze,r+1,c);
        }
        if(c<Maze[0].length-1){
           mazeRestriction(p+'r',Maze,r,c+1);
        }

    }
    /*
     * DDRR 
DDRURD
DDRUURDD
DRDR
DRRD
DRURDD
RDDR
RDRD
RDLDRR
RRDD
RRDLDR
RRDLLDRR
     */
    static void allPath(String p,boolean[][] maze,int r,int c){
          if(r==maze.length-1 && c==maze[0].length-1){
               System.out.println(p);
               return;
          }
          if(!maze[r][c]){
              return;
          }
           maze[r][c]=false;
          if(r < maze.length-1){
             allPath(p+'D',maze,r+1,c);
          }
          if(c < maze[0].length-1){
            allPath(p+'R',maze,r,c+1);
          }
          if(r>0){
            allPath(p+'U',maze,r-1,c);
          }
          if(c>0){
           allPath(p+'L',maze,r,c-1);
          }
          maze[r][c]=true;
    }

    /*
[1, 0, 0]
[2, 0, 0]
[3, 4, 5]
DDRR
[1, 0, 0]
[2, 5, 6]
[3, 4, 7]
DDRURD
[1, 6, 7]
[2, 5, 8]
[3, 4, 9]
DDRUURDD
[1, 0, 0]
[2, 3, 0]
[0, 4, 5]
DRDR
[1, 0, 0]
[2, 3, 4]
[0, 0, 5]
DRRD
[1, 4, 5]
[2, 3, 6]
[0, 0, 7]
DRURDD
[1, 2, 0]
[0, 3, 0]
[0, 4, 5]
RDDR
[1, 2, 0]
[0, 3, 4]
[0, 0, 5]
RDRD
[1, 2, 0]
[4, 3, 0]
[5, 6, 7]
RDLDRR
[1, 2, 3]
[0, 0, 4]
[0, 0, 5]
RRDD
[1, 2, 3]
[0, 5, 4]
[0, 6, 7]
RRDLDR
[1, 2, 3]
[6, 5, 4]
[7, 8, 9]
RRDLLDRR
     */

    static void allPathPrint(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c]=step;
             for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
             }
             System.out.println(p);
             System.out.println();
             return;
        }
        if(!maze[r][c]){
            return;
        }
         maze[r][c]=false;
         path[r][c]=step;
        if(r < maze.length-1){
           allPathPrint(p+'D',maze,r+1,c,path,step+1);
        }
        if(c < maze[0].length-1){
          allPathPrint(p+'R',maze,r,c+1,path,step+1);
        }
        if(r>0){
          allPathPrint(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
         allPathPrint(p+'L',maze,r,c-1,path,step+1);
        }
        maze[r][c]=true;
        path[r][c]=0;

  }
}
