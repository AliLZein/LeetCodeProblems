class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        Set<Integer> setting = new HashSet<>();
        for(int n : nums)
        {
            if(!setting.add(n)){return true;}
        }

        return setting.size() < nums.length;
    }
}