class Solution 
{
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;

        int left = grid[0][0]; 
        int right = n * n - 1;

        while (left < right) 
        {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[n][n];

            if (dfs(grid, 0, 0, mid, visited)) 
            {
                right = mid;
            } 
            else 
            {
                left = mid + 1; 
            }
        }

        return left;
    }

    private boolean dfs(int[][] grid, int r, int c, int t, boolean[][] visited) 
    {
        int n = grid.length;

        if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || grid[r][c] > t) 
        {
            return false;
        }

        if (r == n - 1 && c == n - 1) 
        {
            return true;
        }

        visited[r][c] = true;

        for (int[] dir : dirs) 
        {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (dfs(grid, nextR, nextC, t, visited)) 
            {
                return true;
            }
        }

        return false;
    }
}