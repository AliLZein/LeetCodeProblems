class Solution 
{
    public int maxProfit(int[] prices) 
    {
        if (prices == null || prices.length <= 1) 
        {
            return 0;
        }

        int held = -prices[0];
        int sold = 0;          
        int reset = 0;        

        for (int price : prices) 
        {
            int prevHeld = held;
            int prevSold = sold;
            int prevReset = reset;

            held = Math.max(prevHeld, prevReset - price);

            sold = prevHeld + price;

            reset = Math.max(prevReset, prevSold);
        }

        return Math.max(sold, reset);
    }
}