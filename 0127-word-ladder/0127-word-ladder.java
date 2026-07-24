class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) 
        {
            return 0;
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) 
        {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int level = current.getValue();

            if (word.equals(endWord)) 
            {
                return level;
            }

            char[] wordChars = word.toCharArray();

            for (int i = 0; i < wordChars.length; i++) 
            {
                char originalChar = wordChars[i];

                for (char c = 'a'; c <= 'z'; c++) 
                {
                    if (c == originalChar) continue;

                    wordChars[i] = c;
                    String nextWord = new String(wordChars);

                    if (wordSet.contains(nextWord)) 
                    {
                        queue.add(new Pair<>(nextWord, level + 1));
                        wordSet.remove(nextWord);
                    }
                }

                wordChars[i] = originalChar;
            }
        }

        return 0;
    }
}