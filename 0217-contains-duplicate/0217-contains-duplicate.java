class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        Set<Integer> setting = new HashSet<>();
        for(int n : nums)
        {
            setting.add(n);
        }

        return setting.size() < nums.length;
    }
}