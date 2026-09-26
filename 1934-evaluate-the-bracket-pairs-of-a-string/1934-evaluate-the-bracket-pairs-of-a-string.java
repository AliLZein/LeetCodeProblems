class Solution 
{
    public String evaluate(String s, List<List<String>> knowledge) 
    {
        HashMap<String , String> map = new HashMap<>();
        for(List<String> pair : knowledge)
        {
            map.put(pair.get(0) , pair.get(1));
        }

        int i = 0; int n = s.length();
        StringBuilder sb = new StringBuilder();

        while(i < n)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                int j = i + 1;
                while(j < n && s.charAt(j) != ')')
                {
                    j += 1;
                }
                String key = s.substring(i + 1, j);
                sb.append(map.getOrDefault(key , "?"));
                i = j + 1;
            }
            else
            {
                sb.append(c);
                i += 1;
            }
        }
        return sb.toString();
    }
}