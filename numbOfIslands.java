//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1?page=1&company%5B%5D=Amazon&category%5B%5D=Graph&sortBy=

//Tc: O(n*m) Sc: O(n*m)
class Solution {
    // Function to find the number of islands.
    int[][] dirs;
    public int numIslands(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1')
                {
                    ans++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n)
    {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        
        for(int[] dir: dirs)
        {
            int nr = i+dir[0];
            int nc = j+dir[1];
            
            dfs(grid,nr,nc,m,n);
            
        }
        
    }
}
