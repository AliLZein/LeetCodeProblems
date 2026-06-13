import java.util.ArrayList;
class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        boolean all = false;
        for(int i = 1 ; i < s.length() ; i++)
        {
            if(s.charAt(0) != s.charAt(i)) {break;}
            if(s.charAt(0) == s.charAt(i))
            {
                if(i == s.length() - 1)
                {
                    all = true;
                }
            }
        }
        if(all) return 1;
        int k;
        int old = 0;
        int counter = 1;
        ArrayList<Character> l = new ArrayList<>();
        for(int i = 0 ; i < s.length(); i++)
        {
            k = i + 1;
            if(k >= s.length()) break;
            if(s.charAt(i) == s.charAt(k)) continue;
            l.add(s.charAt(i));
            while(k < s.length())
            {
                if(check(l , s.charAt(k))) {l.add(s.charAt(k)); counter += 1;}
                else{break;}
                k += 1;
            }
            if(counter > old){old = counter;}
            counter = 1;
            makempty(l);
        }
        return Math.max(counter , old);
    }

    public boolean check(ArrayList<Character> l , char c)
    {
        for(int i = 0 ; i < l.size(); i++)
        {
            if(c == l.get(i)) return false;
        }
        return true;
    }

    public void makempty(ArrayList<Character> l)
    {
        while(l.size() > 0)
        {
            l.remove(0);
        }
    }
}
