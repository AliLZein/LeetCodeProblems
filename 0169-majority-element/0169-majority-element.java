class Solution 
{
    int majority = 0; 
    public int majorityElement(int[] nums) 
    {
        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);

        int mid = nums.length / 2;
        return nums[mid];
    }
}