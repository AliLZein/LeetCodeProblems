class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        if (hand.length % groupSize != 0) 
        {
            return false;
        }

        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) 
        {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        while (!count.isEmpty()) 
        {
            int first = count.firstKey();

            for (int i = 0; i < groupSize; i++) 
            {
                int currentCard = first + i;

                if (!count.containsKey(currentCard)) 
                {
                    return false;
                }

                int currentCount = count.get(currentCard);
                if (currentCount == 1) 
                {
                    count.remove(currentCard);
                } 
                else 
                {
                    count.put(currentCard, currentCount - 1);
                }
            }
        }

        return true;
    }
}