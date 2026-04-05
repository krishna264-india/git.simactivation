import java.util.List;

public class UndetectedCycle {
    public static void main(String[] args){
        UndetectedCycle cycleDetector = new UndetectedCycle();
        int V = 5;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0}, // This edge creates a cycle
            {1, 3},
            {3, 4}
        };
        boolean hasCycle = cycleDetector.isCycle(V, edges);
        System.out.println("Graph contains cycle: " + hasCycle);

    }
     public boolean isCycle(int V, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Add edges to the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // Initialize visited array
        boolean[] visited = new boolean[V];
        // Check for cycles in each component 
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle detected
            }
        }
        return false;
    }
    
}
