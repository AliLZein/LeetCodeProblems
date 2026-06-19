class Solution {
    public boolean isValid(String s) 
    {
        if(s.length() % 2 != 0 ){return false;}
        String open = "([{";
        String close = ")]}";
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(open.indexOf(s.charAt(i)) != -1)
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(st.isEmpty()){return false;}
                int value = open.indexOf(st.pop());
                if(s.charAt(i) != close.charAt(value)){return false;}
            }
        }
        if(st.size() == s.length()){return false;}
        if(!(st.isEmpty())){return false;}
        return true;
    }
}