class Solution 
{
    public int maxDepth(String s) 
    {
        int max = 0;
        int depth = 0;
        char[] list = s.toCharArray();

        for(int c : list)
        {
            if(c == '(') depth += 1;
            if(c == ')')
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