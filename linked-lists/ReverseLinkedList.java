// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList 
{
    public class ListNode
    {
        int val;
        ListNode next;
        
        public ListNode(int x) 
        { 
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) 
    {
        if (head == null)
            return null;
        
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head;
        
        while (currNode != null)
        {
            nextNode = nextNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        return prevNode;
    }
}