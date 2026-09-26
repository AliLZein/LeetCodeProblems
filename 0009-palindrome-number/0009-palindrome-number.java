class Solution 
{
    public boolean isPalindrome(int x) 
    {
        if(x < 0)
        {
            return false;
        }
        if(x == 0)
        {
            return true;
        }

        int answer = 0;
        int before = x;

        while(x != 0)
        {
            int digit = x % 10;
            answer = (answer * 10) + digit;
            x /= 10;
        }

        if(answer == before)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}