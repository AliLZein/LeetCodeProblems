class Solution 
{
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if (head == null || k == 1) return head;

        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) 
        {
            curr = curr.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        curr = head;
        ListNode prev = null;
        ListNode nextNode = null;

        for (int i = 0; i < k; i++) {
            nextNode = curr.next;
            curr.next = prev;  
            prev = curr;         
            curr = nextNode;    
        }

        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }

        return prev;
    }
}