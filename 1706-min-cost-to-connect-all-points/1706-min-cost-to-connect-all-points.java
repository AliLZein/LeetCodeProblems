import java.util.Arrays;

class Solution 
{
    public int minCostConnectPoints(int[][] points) 
    {
        int n = points.length;
        int totalCost = 0;
        
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        
        boolean[] inMST = new boolean[n];
        
        for (int step = 0; step < n; step++) 
        {
            int currPoint = -1;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && (currPoint == -1 || minDist[i] < minDist[currPoint])) 
                {
                    currPoint = i;
                }
            }
            
            inMST[currPoint] = true;
            totalCost += minDist[currPoint];
            
            for (int nextPoint = 0; nextPoint < n; nextPoint++) 
            {
                if (!inMST[nextPoint]) 
                {
                    int dist = Math.abs(points[currPoint][0] - points[nextPoint][0]) + 
                               Math.abs(points[currPoint][1] - points[nextPoint][1]);
                    
                    if (dist < minDist[nextPoint]) 
                    {
                        minDist[nextPoint] = dist;
                    }
                }
            }
        }
        
        return totalCost;
    }
}