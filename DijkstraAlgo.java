//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

//Using a queue
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        //Tc: O(V^2) Sc: O(V^2)
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        // Create a queue to store the vertices to be processed
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            // Traverse all adjacent vertices of the current vertex
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);
                
                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    queue.add(v);
                }
            }
        }
        
        return dist;
    }
}




class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    Tc: O(V+E)logV  Sc: O(V+E)
     static class Pair {
        int vertex;
        int distance;

        Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        // Create a priority queue to store the vertices to be processed
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;

            // Traverse all adjacent vertices of the current vertex
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}

