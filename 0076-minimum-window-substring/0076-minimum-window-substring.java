class Solution 
{
    public String minWindow(String s, String t) 
    {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] targetCounts = new int[128];
        for (char c : t.toCharArray()) 
        {
            targetCounts[c]++;
        }

        int[] windowCounts = new int[128];
        int start = 0;
        int matchedCount = 0;
        
        int minLen = Integer.MAX_VALUE;
        int bestStart = 0;

        int requiredMatches = 0;
        for (int count : targetCounts) 
        {
            if (count > 0) requiredMatches++;
        }

        for (int end = 0; end < s.length(); end++) 
        {
            char rightChar = s.charAt(end);
            windowCounts[rightChar]++;
            if (targetCounts[rightChar] > 0 && windowCounts[rightChar] == targetCounts[rightChar]) 
            {
                matchedCount++;
            }

            while (matchedCount == requiredMatches) 
            {
                if (end - start + 1 < minLen) 
                {
                    minLen = end - start + 1;
                    bestStart = start;
                }

                char leftChar = s.charAt(start);
                windowCounts[leftChar]--;

                if (targetCounts[leftChar] > 0 && windowCounts[leftChar] < targetCounts[leftChar]) 
                {
                    matchedCount--;
                }
                
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + minLen);
    }
}