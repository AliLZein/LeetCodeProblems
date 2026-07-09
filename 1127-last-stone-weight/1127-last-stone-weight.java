import java.util.Collections;
import java.util.PriorityQueue;
class Solution 
{
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int n : stones)
        {
            pq.add(n);
        }

        while(pq.size() > 1)
        {
            int biggest = pq.poll();
            int sbiggest = pq.poll();

            if(biggest != sbiggest)
            {
                pq.add(biggest - sbiggest);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}