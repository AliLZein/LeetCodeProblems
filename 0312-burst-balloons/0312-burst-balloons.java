class Solution 
{
    public int maxCoins(int[] nums) 
    {
        int n = nums.length;
        
        int[] padded = new int[n + 2];
        padded[0] = 1;
        padded[n + 1] = 1;
        for (int i = 0; i < n; i++) 
        {
            padded[i + 1] = nums[i];
        }

        int[][] memo = new int[n + 2][n + 2];

        return solve(padded, 0, n + 1, memo);
    }

    private int solve(int[] nums, int left, int right, int[][] memo) 
    {
        if (left + 1 == right) 
        {
            return 0;
        }

        if (memo[left][right] != 0) 
        {
            return memo[left][right];
        }

        int maxCoins = 0;

        for (int k = left + 1; k < right; k++) 
        {
            int coins = nums[left] * nums[k] * nums[right];
            
            int total = coins + solve(nums, left, k, memo) + solve(nums, k, right, memo);

            maxCoins = Math.max(maxCoins, total);
        }

        memo[left][right] = maxCoins;
        return maxCoins;
    }
}