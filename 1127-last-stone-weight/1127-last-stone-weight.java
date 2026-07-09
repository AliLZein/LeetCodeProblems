import java.util.Collections;
class Solution 
{
    public int lastStoneWeight(int[] stones) 
    {
        ArrayList<Integer> list = new ArrayList<>(stones.length);
        for(int num : stones)
        {
            list.add(num);
        }
        while(list.size() >= 2)
        {
            Collections.sort(list);

            int lastindx = list.size() - 1;
            int secondlastindx = list.size() - 2;

            if(list.get(lastindx) == list.get(secondlastindx))
            {
                list.remove(lastindx); 
                list.remove(secondlastindx);
            }
            else
            {
                int newValue = list.get(lastindx) - list.get(secondlastindx);
                list.set(lastindx , newValue); 
                list.remove(secondlastindx);
            }
        }
        return list.isEmpty() ? 0 : list.get(0);    
    }
}