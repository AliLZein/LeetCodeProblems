class Solution 
{
    public boolean isPalindrome(String s) 
    {
        if(s.length() == 0 || s.equals(" ")){return true;}
        String word = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < word.length() ; i++)
        {
            if((word.charAt(i) >= 97 && word.charAt(i) <= 122) || word.charAt(i) >= 48 && word.charAt(i) <= 57){sb.append(word.charAt(i));}
        }
        if(sb.length() == 2)
        {
            if(sb.charAt(0) != sb.charAt(1)){return false;}
            else{return true;}
        }
        int j = sb.length() - 1;
        for(int i = 0 ; i < sb.length() / 2 ; i++)
        {
            if(sb.charAt(i) != sb.charAt(j)){return false;}
            j -= 1;
        }

        return true;
    }
}