/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode reverseList(ListNode head) 
    {
        if(head == null){return head;}

        Stack<ListNode> s = new Stack<>();

        ListNode t = head;
        while(t != null)
        {
            s.push(t);
            t = t.next;
        }

        ListNode dummy = s.pop();
        t = dummy;

        while(!s.isEmpty())
        {
            t.next = s.pop();
            t = t.next;
        }

        t.next = null;

        return dummy;
    }
}