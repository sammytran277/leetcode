// https://leetcode.com/problems/linked-list-cycle/

public class LinkedListCycle 
{
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Find cycles using the slow-fast pointer technique
    public boolean hasCycle(ListNode head) 
    {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
            if (slow == fast)
                return true;
        }
        
        return false;
    }
}