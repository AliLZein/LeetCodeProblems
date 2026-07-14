class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int downOne = cost[1];
        int downTwo = cost[0];
        
        for (int i = 2; i < cost.length; i++) 
        {
            int current = cost[i] + Math.min(downOne, downTwo);
            
            downTwo = downOne;
            downOne = current;
        }
        
        return Math.min(downOne, downTwo);
    }
}