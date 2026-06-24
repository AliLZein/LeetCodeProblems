import java.util.Arrays;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0){return result;}
        Arrays.sort(candidates);
        backtrack(result , new ArrayList<>() , candidates , target , 0);
        return result;        
    }

    private void backtrack(List<List<Integer>> result , List<Integer> currentlist , int[] candidates ,int remain , int start)
    {
        if(remain < 0){return;}
        if(remain == 0)
        {
            result.add(new ArrayList<>(currentlist));
            return;
        }

        for(int i = start ; i < candidates.length ; i++)
        {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            if(candidates[i] > remain) break;

            currentlist.add(candidates[i]);
            backtrack(result , currentlist , candidates,remain - candidates[i] , i + 1);
            currentlist.remove(currentlist.size() - 1);
        }
    }
}