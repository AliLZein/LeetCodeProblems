class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> list = new ArrayList<>();
        if(strs == null || strs.length == 0){return list;}

        HashMap<String , List<String>> hash = new HashMap<>();

        for(String word : strs)
        {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(!hash.containsKey(sorted))
            {
                hash.put(sorted , new ArrayList<>());
            }

            hash.get(sorted).add(word);
        }

        return new ArrayList<>(hash.values());
    }
}