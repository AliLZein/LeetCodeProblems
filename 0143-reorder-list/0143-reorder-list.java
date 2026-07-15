import java.util.Stack;

class Solution 
{
    public void reorderList(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return;
        }


        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = slow.next;
        slow.next = null;
        
        while (curr != null) 
        {
            stack.push(curr);
            curr = curr.next;
        }

        ListNode first = head;
        while (!stack.isEmpty()) {
            ListNode second = stack.pop();
            
            ListNode nextFirst = first.next;
            first.next = second;
            second.next = nextFirst;
            
            first = nextFirst;
        }
    }
}