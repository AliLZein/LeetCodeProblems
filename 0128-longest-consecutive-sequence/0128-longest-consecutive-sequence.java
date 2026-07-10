class Solution 
{

    public int longestConsecutive(int[] nums) 
    {
        if(nums == null || nums.length == 0){return 0;}
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
        }

        int longeststreak = 0;
        for(int num : set)
        {
            if(!set.contains(num - 1))
            {
                int number = num;
                int currentStreak = 1;

                while(set.contains(number + 1))
                {
                    currentStreak += 1;
                    number += 1;
                    continue;
                }
                longeststreak = Math.max(longeststreak , currentStreak);
            }
        }
        return longeststreak;
    }
}