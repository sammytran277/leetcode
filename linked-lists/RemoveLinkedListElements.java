// https://leetcode.com/problems/remove-linked-list-elements/

public class RemoveLinkedListElements 
{
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) 
    {
        // Check for edge cases like null head or when the head is equal to val
        if (head == null)
            return head;
        while (head != null && head.val == val)
            head = head.next;
        
        // Delete nodes by keeping track of previous node and changing references
        ListNode currNode = head;
        ListNode prevNode = null;
        while (currNode != null)
        {
            if (currNode.val == val)
                prevNode.next = currNode.next;
            else
                prevNode = currNode;
            
            currNode = currNode.next;
        }
        
        return head;
    }
}