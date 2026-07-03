class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int[][] memo = new int[m][n];
        return search(m , n , 0 , 0 , memo);
    }

    public int search(int m , int n , int placem , int placen , int[][] memo)
    {
        if(placem >= m || placen >= n){return 0;}
        if(placem == m - 1 && placen == n - 1){return 1;}
        if(memo[placem][placen] != 0)
            {
                return memo[placem][placen];
            }
        memo[placem][placen] = search(m , n , placem + 1 , placen , memo) + search( m , n , placem , placen + 1 , memo);
        return memo[placem][placen];
    }
}