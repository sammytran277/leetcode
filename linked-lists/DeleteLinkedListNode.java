// https://leetcode.com/problems/delete-node-in-a-linked-list/

public class DeleteLinkedListNode 
{
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) 
    {   
        ListNode currNode = node;
        while (currNode != null)
        {
            currNode.val = currNode.next.val;
            if (currNode.next.next == null)
                currNode.next = null;
            currNode = currNode.next;
        }
    }
}