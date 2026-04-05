import java.util.*;
public class Maze {
    public static void main(String[] args){
      //System.out.println(countMaze(3,3));
      //mazePath("",3,3);

      //System.out.println(Path("",3,3));
      System.out.println(PathDiagonal("",3,3));
    }
   static int countMaze(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int left=countMaze(r-1,c);
        int right=countMaze(r,c-1);
        return(left+right);
    }
    static void mazePath(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            mazePath(p+'D',r-1,c);
        }
        if(c>1){
           mazePath(p+'R',r,c-1);
        }
    }

    static ArrayList<String> Path(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1){
            list.addAll(Path(p+'D',r-1,c));
        }
        if(c>1){
             list.addAll(Path(p+'R',r,c-1));
        }
        return list;
    }

    static ArrayList<String> PathDiagonal(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1 && c>1){
             list.addAll(PathDiagonal(p+'D',r-1,c-1));
        }
        if(r>1){
            list.addAll(PathDiagonal(p+'L',r-1,c));
        }
        if(c>1){
             list.addAll(PathDiagonal(p+'H',r,c-1));
        }
        return list;
    }
}
