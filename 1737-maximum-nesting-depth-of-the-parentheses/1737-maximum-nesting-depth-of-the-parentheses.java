class Solution 
{
    public int maxDepth(String s) 
    {
        int max = 0;
        int depth = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == '(') depth += 1;
            if(s.charAt(i) == ')')
            {
                if(max < depth)
                {
                    max = depth;
                }
                depth -= 1;
            }
        }
        return max;
    }
}