class Solution 
{
    public int reverse(int num) 
    {
        long answer = 0;
        while(num != 0)
        {
            int number = num % 10;
            answer = (answer * 10)  + number;
            num /= 10;
        }
        if (answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)answer;
    }
}