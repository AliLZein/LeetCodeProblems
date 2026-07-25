class Solution 
{
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) 
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
        {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxPath = 0;

        for (int r = 0; r < m; r++) 
        {
            for (int c = 0; c < n; c++) 
            {
                maxPath = Math.max(maxPath, dfs(matrix, r, c, memo));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) 
    {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int maxLen = 1;

        for (int[] dir : DIRECTIONS) 
        {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newR < matrix.length && newC >= 0 && newC < matrix[0].length 
                && matrix[newR][newC] > matrix[r][c]) 
                {
                
                int len = 1 + dfs(matrix, newR, newC, memo);
                maxLen = Math.max(maxLen, len);
            }
        }

        memo[r][c] = maxLen;
        return maxLen;
    }
}