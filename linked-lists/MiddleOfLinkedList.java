// https://leetcode.com/problems/middle-of-the-linked-list/ 

public class MiddleOfLinkedList {
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Get the middle of a linked list using the slow-fast pointer technique
    public ListNode middleNode(ListNode head) 
    {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}