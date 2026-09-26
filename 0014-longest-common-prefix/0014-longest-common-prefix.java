class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        if (strs == null || strs.length == 0) return "";
        
        StringBuilder prefix = new StringBuilder();
        Arrays.sort(strs);
        
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        int limit = Math.min(first.length(), last.length());
        int i = 0;
        
        while (i < limit)
        {
            if (first.charAt(i) == last.charAt(i))
            {
                prefix.append(first.charAt(i));
                i += 1;
            }
            else
            {
                break;
            }
        }
        return prefix.toString();
    }
}