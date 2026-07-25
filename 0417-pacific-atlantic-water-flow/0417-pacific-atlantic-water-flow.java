class Solution 
{
    private int rows;
    private int cols;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) 
        {
            return result;
        }

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) 
        {
            dfs(0, c, heights, pacific, heights[0][c]); 
            dfs(rows - 1, c, heights, atlantic, heights[rows - 1][c]);
        }

        for (int r = 0; r < rows; r++) 
        {
            dfs(r, 0, heights, pacific, heights[r][0]);      
            dfs(r, cols - 1, heights, atlantic, heights[r][cols - 1]);
        }

        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) 
            {
                if (pacific[r][c] && atlantic[r][c]) 
                {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean, int prevHeight) 
    {
        if (r < 0 || r >= rows || c < 0 || c >= cols || ocean[r][c] || heights[r][c] < prevHeight) 
        {
            return;
        }

        ocean[r][c] = true;

        for (int[] dir : directions) 
        {
            dfs(r + dir[0], c + dir[1], heights, ocean, heights[r][c]);
        }
    }
}