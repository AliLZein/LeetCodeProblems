class Solution 
{
    public int maxAreaOfIsland(int[][] grid) 
    {
        int maxArea = 0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                if(grid[i][j] == 1)
                {
                    int area = dfs(grid , i , j);
                    maxArea = Math.max(maxArea , area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid , int i , int j)
    {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0){return 0;}

        grid[i][j] = 0;

        int area = 1;
        area += dfs(grid , i + 1 , j);
        area += dfs(grid , i , j + 1);
        area += dfs(grid , i - 1 , j);
        area += dfs(grid , i , j - 1);

        return area;
    }
}