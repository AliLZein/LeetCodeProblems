import java.util.Arrays;
class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] flat = new int[rows * cols];
        int index = 0;

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                flat[index++] = matrix[i][j];
            }
        }

        Arrays.sort(flat);

        for(int i = 0 ; i < flat.length ; i++)
        {
            if(flat[i] == target){return true;}
            else if(target < flat[i]){return false;}
        }
        return false;
    }
}