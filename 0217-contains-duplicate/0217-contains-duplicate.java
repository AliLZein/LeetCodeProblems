class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        Arrays.sort(nums);

        for(int i = 0 ; i< nums.length ; i++)
        {
            int j = i + 1;
            if(j == nums.length){break;}
            if(nums[i] == nums[j]){return true;}
        }
        
        return false;
    }
}