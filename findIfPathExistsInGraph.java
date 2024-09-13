//https://leetcode.com/problems/find-if-path-exists-in-graph/description/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Tc: O(V+E)  Sc: O(V+E)
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            map.put(i, new ArrayList<>());
        }

        for(int[] i: edges)
        {
            int u = i[0];
            int v = i[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited.add(source);

        while(!q.isEmpty())
        {
            int node = q.poll();
            if(node == destination) return true;

            for(int neigh: map.get(node))
            {
                if(!visited.contains(neigh)) {
                    visited.add(neigh);
                    q.add(neigh);
                }
            }
        }

        return false;

    }
}
