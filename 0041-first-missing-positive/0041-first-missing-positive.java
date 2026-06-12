import java.util.Arrays;
class Solution {
    public int firstMissingPositive(int[] nums) 
    {
        boolean find = false;
        boolean go = true;
        Arrays.sort(nums);
        int smallest = nums[0];
        if(nums.length == 1)
        {
            if(nums[0] == 1) {smallest = 2; go = false; find = true;}
            if(nums[0] > 1 || smallest <= 0){smallest = 1; go = false; find = true;}
        }
        if(nums[nums.length - 1] <= 0)
        {
            smallest = 1; go = false; find = true;
        }
        if(nums[0] != 1 && nums[0] != 0 && nums[0] > 0)
        {
            smallest = 1;
            go = false;
            find = true;
        }
        if(go == true)
        {
            for(int i = 0 ; i < nums.length - 1 ; i++)
            {
                if(nums[i] <= 0) continue;
                if(nums[i] + 1 != nums[i + 1] && nums[i] != nums[i + 1]) {smallest = nums[i] + 1; find = true; break;}
            }
        }
        if(go){
        boolean def = true;
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] == 1) {def = false;}
        }
        if(def) return 1;}
        if(find == false){smallest = nums[nums.length - 1] + 1;}
        return smallest;
    }
}