import java.util.Stack;

class Solution 
{
    public boolean checkValidString(String s) 
    {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> asterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if (c == '(') 
            {
                stack.push(i);
            } 
            else if (c == '*') 
            {
                asterStack.push(i);
            } 
            else 
            {
                if (!stack.isEmpty()) 
                {
                    stack.pop();
                } 
                else if (!asterStack.isEmpty()) 
                {
                    asterStack.pop();
                } 
                else {
                    return false;
                }
            }
        }

        while (!stack.isEmpty() && !asterStack.isEmpty()) 
        {
            if (stack.pop() > asterStack.pop()) 
            {
                return false; 
            }
        }

        return stack.isEmpty();
    }
}