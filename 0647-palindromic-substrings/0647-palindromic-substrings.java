class Solution 
{
    public int countSubstrings(String s) 
    {
        if(s == null || s.length() == 0){return 0;}

        int answer = s.length();
        int j;

        for(int i = 0 ; i < s.length() ; i++)
        {
            j = i + 1;
            while(j < s.length())
            {
                if(palindrome(s.substring(i , j + 1))){answer += 1;}
                j += 1;
            }
        } 
        return answer; 
    }

    public boolean palindrome(String s)
    {
        int j = s.length() - 1;
        int i = 0;
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j)){return false;}
            j -= 1;
            i += 1;
        }
        return true;
    }
}