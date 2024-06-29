//https://www.geeksforgeeks.org/problems/topological-sort/1?page=1&company%5B%5D=Amazon&category%5B%5D=Graph&sortBy=


class Solution
{
    //Tc: O(V+E) Sc: O(V)
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adjList) 
    {
        // add your code here
        int[] inDegree = new int[V];
        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Initialize the queue with all vertices having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Array to store the topological order
        int[] topoOrder = new int[V];
        int index = 0;

        // Process the vertices in the queue
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            topoOrder[index++] = vertex;

            // Decrease the in-degree of all neighbors
            for (int neighbor : adjList.get(vertex)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return topoOrder;
    }
}
