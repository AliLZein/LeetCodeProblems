import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        while (true) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) current.add(num);
            result.add(current);

            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) i--;
            
            if (i < 0) break; 
            
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            
            swap(nums, i, j);
            reverse(nums, i + 1);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}