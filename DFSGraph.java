//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?page=1&company%5B%5D=Amazon&category%5B%5D=Graph&sortBy=

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    //Tc: O(V+E) Sc: O(V)
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean visited[] = new boolean[V];
        dfs(0, visited, adj, ans);
        return ans;
    }
    
    private void dfs(int V, boolean[] visited, ArrayList<ArrayList<Integer>> adj,  ArrayList<Integer> ans)
    {
        visited[V] = true;
        // Add the current vertex to the result list
        ans.add(V);
        
        // Visit all adjacent vertices of vertex v
        for (int neighbor : adj.get(V)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, ans);
            }
        }
    }
}
