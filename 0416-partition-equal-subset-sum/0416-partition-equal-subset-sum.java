class Solution 
{
    public boolean canPartition(int[] nums) 
    {
        int totalSum = 0;
        int maxNum = 0;

        for (int num : nums) 
        {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        if (maxNum > target) return false;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) 
        {
            for (int i = target; i >= num; i--) 
            {
                dp[i] = dp[i] || dp[i - num];
            }
            
            if (dp[target]) return true;
        }

        return dp[target];
    }
}