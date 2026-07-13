import java.util.Arrays;

class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int[] counts = new int[26];
        for (char c : tasks) 
        {
            counts[c - 'A']++;
        }
        
        int[] nextAvailableTime = new int[26];
        
        int totalTasksRemaining = tasks.length;
        int currentTime = 0;
        
        while (totalTasksRemaining > 0) {
            currentTime++;
            
            int bestTaskIndex = -1;
            int maxFrequency = 0;
            
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0 && currentTime >= nextAvailableTime[i]) {
                    if (counts[i] > maxFrequency) {
                        maxFrequency = counts[i];
                        bestTaskIndex = i;
                    }
                }
            }
            
            if (bestTaskIndex != -1) {
                counts[bestTaskIndex]--; 
                nextAvailableTime[bestTaskIndex] = currentTime + n + 1;
                totalTasksRemaining--;
            }
        }
        
        return currentTime;
    }
}