class Trie 
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

    public Trie() 
    {
        root = new TrieNode();
    }
    
    public void insert(String word) 
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
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) 
    {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String str) 
    {
        TrieNode curr = root;

        for (char c : str.toCharArray()) 
        {
            int index = c - 'a';
            if (curr.children[index] == null) 
            {
                return null;
            }
            curr = curr.children[index];
        }

        return curr;
    }
}