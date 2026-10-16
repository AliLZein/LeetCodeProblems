import java.util.Arrays;

class Solution 
{
    public int countElements(int[] nums, int k) 
    {
        int answer = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
            int firstGreaterIdx = upperBound(nums, nums[i]);
            int strictlyGreater = nums.length - firstGreaterIdx;

            if (strictlyGreater >= k)
            {
                answer += 1;
            }
        }

        return answer;
    }

    public int upperBound(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target)
            {
                ans = mid;
                right = mid - 1; 
            }
            else
            {
                left = mid + 1;
            }
        }

        return ans;
    }
}