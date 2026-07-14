class Solution 
{
    public int hammingWeight(int n) 
    {
        if(n == 0){return 0;}

        int answer = 0;
        while(n > 0)
        {
            if(n % 2 == 1){answer += 1;}
            n /= 2;
        }

        return answer;
    }
}