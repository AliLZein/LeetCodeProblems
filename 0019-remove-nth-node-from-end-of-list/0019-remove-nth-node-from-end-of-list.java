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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head == null)
        {
            return null;
        }
        int k = 1;
        ListNode size = head;
        while(size.next != null){size = size.next ; k += 1;}
        if(k == 1)
        {
            return null;  
        }
        ListNode temp = head;
        int i = k - n;
        if(i == 0)
        {
            head = head.next;
            return head;
        }
        else
        {
            int j = 0;
            while(temp.next != null && j < i - 1)
            {
                temp = temp.next;
                j += 1;
            }
            ListNode dummy = temp.next;
            temp.next = dummy.next;
            dummy.next = null;
        }
        return head;

    }
}