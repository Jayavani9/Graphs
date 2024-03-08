547. Number of Provinces

There are n cities. Some of them are connected, while some are not. 
If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3


//DFS Solution 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int ans = 0;    

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
            ans++;
            dfs(isConnected, visited, i);
            }

        }

        return ans;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int index)
    {
        visited[index] = true;

        for(int j = 0; j < isConnected.length; j++)
        {
            if(!visited[j] && isConnected[index][j] == 1)
            {
                dfs(isConnected, visited, j);
            }
        }

    }
}


//BFS Solution

/*
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            if(!visited[i]){
                q.add(i);
                ans++;

                while(!q.isEmpty())
                {
                    int node = q.poll();
                    visited[node] = true;

                    for(int j = 0; j < n; j++)
                    {
                        if(isConnected[node][j] == 1 && !visited[j])
                        {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }


        return ans;

        
    }
}

*/
