class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) 
        {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : count.keySet()) 
        {
            int freq = count.get(key);
            if (bucket[freq] == null) 
            {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] result = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) 
        {
            if (bucket[pos] != null) 
            {
                for (int num : bucket[pos]) 
                {
                    result[counter++] = num;
                    if (counter == k) break;
                }
            }
        }

        return result;
    }
}