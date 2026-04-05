import java.util.LinkedList;
import java.util.Queue;

public class TwoDArray {
    public static void main(String[] args) {
        
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int numIsLand=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){// found an island
                    numIsLand++;//  increment count
                    dfs(grid,i,j);// mark all connected lands
                }
            }
        }
        return numIsLand;
    }
    private void dfs(char[][] grid,int i,int j){
        int rows=grid.length;
        int cols=grid[0].length;
        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';// mark as visited
        dfs(grid,i+1,j);// down
        dfs(grid,i-1,j);// up
        dfs(grid,i,j+1);// right
        dfs(grid,i,j-1);// left
    }
    public int findCircleNum(int[][] isConnected) {
        
        int n=isConnected.length;
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected,visited,i,n);   
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected,boolean[] visited,int i,int n){
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                visited[j]=true;
                dfs(isConnected,visited,j,n);
            }
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        // Step 1: Count fresh oranges and add rotten ones to queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) queue.add(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        // If no fresh oranges, answer is 0
        if(fresh==0) return 0;
        int minutes = -1;
        while(!queue.isEmpty()){
            int size=queue.size();
             for(int i=0;i<size;i++){
                int[] rottenIndex=queue.poll();
                int r=rottenIndex[0];
                int c=rottenIndex[1];
                //bottom
                if(r+1<n && grid[r+1][c]==1){
                    grid[r+1][c]==2;
                    queue.add(new int[]{r+1,c});
                     fresh--;
                }
                //top
                if(r-1>=0 && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    queue.add(new int[]{r-1,c});
                    fresh--;
                }
                //top
                if(c-1>=0 && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    queue.add(new int[]{r,c-1});
                    fresh--;
                }
                if(c+1<m && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                queue.add(new int[]{r,c+1});
                fresh--;
                }
             }
             minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}

