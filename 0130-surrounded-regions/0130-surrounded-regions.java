class Solution 
{
    public void solve(char[][] board) 
    {
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                boolean onedge = i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
                if(onedge && board[i][j] == 'O'){helper(board , i , j);}
            }
        }
        for(int k = 0 ; k < board.length ; k++)
        {
            for(int p = 0 ; p < board[0].length ; p++)
            {
                if(board[k][p] == 'O')
                {
                    board[k][p] = 'X';
                }
                else if(board[k][p] == '#')
                {
                    board[k][p] = 'O';
                }
            }
        }
    }

    public void helper(char[][] board , int i , int j)
    {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0){return;}
        if(board[i][j] != 'O'){return;}
        
        board[i][j] = '#';

        helper(board , i + 1 , j);
        helper(board , i , j + 1);
        helper(board , i - 1 , j);
        helper(board,  i  , j - 1);
    }
}