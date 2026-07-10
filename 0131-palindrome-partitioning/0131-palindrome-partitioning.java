import java.util.ArrayList;
import java.util.List;

class Solution 
{
    public List<List<String>> partition(String s) 
    {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) 
        {
            dp[i][i] = true;
        }
        
        for (int length = 2; length <= n; length++) 
        {
            for (int start = 0; start <= n - length; start++) 
            {
                int end = start + length - 1;
                if (s.charAt(start) == s.charAt(end)) 
                {
                    if (length == 2 || dp[start + 1][end - 1]) 
                    {
                        dp[start][end] = true;
                    }
                }
            }
        }

        dfs(s, 0, dp, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, int start, boolean[][] dp, List<String> currentPartition, List<List<String>> result) 
    {
        if (start == s.length()) 
        {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = start; i < s.length(); i++)
        {
            if (dp[start][i]) {
                String substring = s.substring(start, i + 1);
                currentPartition.add(substring);
                dfs(s, i + 1, dp, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
}