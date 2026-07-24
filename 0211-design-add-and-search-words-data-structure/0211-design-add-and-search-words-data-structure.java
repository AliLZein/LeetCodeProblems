class WordDictionary 
{

    private class TrieNode 
    {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() 
        {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public WordDictionary() 
    {
        root = new TrieNode();
    }
    
    public void addWord(String word) 
    {
        TrieNode curr = root;
        for (char c : word.toCharArray()) 
        {
            int index = c - 'a';
            if (curr.children[index] == null) 
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) 
    {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) 
    {
        if (index == word.length()) 
        {
            return curr.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') 
        {
            for (TrieNode child : curr.children) 
            {
                if (child != null && dfs(word, index + 1, child)) 
                {
                    return true;
                }
            }
            return false;
        } 
        else 
        {
            int childIndex = c - 'a';
            TrieNode child = curr.children[childIndex];
            if (child == null) 
            {
                return false;
            }
            return dfs(word, index + 1, child);
        }
    }
}