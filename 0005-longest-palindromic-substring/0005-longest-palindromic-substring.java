import java.util.ArrayList;
class Solution {
    public String longestPalindrome(String s) 
    {
        if(s.length() == 0) return "";
        if(s.length() == 1) return s;
        String previous = "";
        String[] ls = new String[1];
        for(int i = 0 ; i < s.length() ; i++)
        {
            int k = i + 1;
            if(k - 1 - s.length() == 0) {break;}
            while(true)
            {
                if(k - 1 - s.length() == 0) {break;}
                if(pali(s.substring(i , k)))
                {
                    ls[0] = s.substring(i , k);
                }
                k += 1;
            }
            if(previous.length() < ls[0].length()) {previous = ls[0];}
            ls[0] = "";
        }
        return previous;
    } 
        
    public boolean pali(String s)
    {
        int i = 0;
        int k = s.length() - 1;
        while(i < k && i < s.length() && k >= 0)
        {
            if(s.charAt(i) != s.charAt(k)) return false;
            i += 1;
            k -= 1;         
        }
        return true;
    }

}