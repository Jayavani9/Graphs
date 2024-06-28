//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?page=1&company%5B%5D=Amazon&category%5B%5D=Graph&sortBy=

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //Tc: O(V+E)  Sc: O(V)
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty())
        {
            
            int cur = q.poll();
            ans.add(cur);
            
            for(int neighbor: adj.get(cur))
            {
                if(!visited[neighbor])
                {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return ans;
    }
}
