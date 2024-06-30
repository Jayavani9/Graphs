//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1


class Solution {
    // Function to detect cycle in a directed graph.
    //Tc: O(V+E)  Sc: O(V+E)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
         int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            count++;

            for (int neighbor : adj.get(vertex)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return count != V;
    }
}
