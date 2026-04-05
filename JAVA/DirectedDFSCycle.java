import java.util.ArrayList;

public class DirectedDFSCycle {
    public boolean isCyclic(int V, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        // Initialize adjacency list
        for(int i=0;i<V;i++){
            // Create a new list for each vertex
            adj.add(new ArrayList<>());
        }  
        // Add edges to the adjacency list
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        // Arrays to keep track of visited nodes and recursion stack
        boolean[] visited=new boolean[V];
        boolean[] recStack=new boolean[V];
        // Perform DFS for each vertex
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,recStack)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and add to recursion stack
        visited[node]=true;
        recStack[node]=true;
        // Recur for all neighbors
        for(int neighbor:adj.get(node)){
            // If the neighbor is not visited, recurse on it
            if(!visited[neighbor]){
                if(dfs(neighbor,adj,visited,recStack)){
                    return true;
                }
            }
            // If the neighbor is in the recursion stack, we found a cycle
            else if(recStack[neighbor]){
                return true;
            }
        }
        // Remove the node from recursion stack before backtracking
        recStack[node]=false;
        return false;
     }
}
