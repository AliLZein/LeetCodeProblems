class Solution 
{
    
    private class TrieNode 
    {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) 
    {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) 
            {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) 
    {
        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null) 
        {
            return;
        }

        node = node.children[ch - 'a'];

        if (node.word != null) 
        {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';


        if (r > 0) dfs(board, r - 1, c, node, result);
        if (r < board.length - 1) dfs(board, r + 1, c, node, result);
        if (c > 0) dfs(board, r, c - 1, node, result);
        if (c < board[0].length - 1) dfs(board, r, c + 1, node, result);

        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) 
    {
        TrieNode root = new TrieNode();
        for (String word : words) 
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
            curr.word = word;
        }
        return root;
    }
}