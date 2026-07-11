class Solution 
{
    public int trap(int[] height) 
    {
        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        int totalwater = 0;

        while(left < right)
        {
            if(height[left] > leftmax){leftmax = height[left];}
            if(height[right] > rightmax){rightmax = height[right];}
            if(height[left] < height[right])
            {
                totalwater += (leftmax - height[left]); 
                left += 1;
            }
            else
            {
                totalwater += (rightmax - height[right]);
                right -= 1;
            }
        }

        return totalwater;
    }
}