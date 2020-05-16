public class OddEvenLinkedList
{
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) 
    {
        if (head == null)
            return head;
        
        ListNode currOddNode = head;
        ListNode currEvenNode = head.next;
        ListNode evenHead = head.next;
        
        while (currOddNode.next != null) 
        {
            currOddNode.next = currOddNode.next.next;
            if (currOddNode.next != null) 
            {
                currEvenNode.next = currEvenNode.next.next;
                currOddNode = currOddNode.next;
                currEvenNode = currEvenNode.next;
            }
        }
        
        currOddNode.next = evenHead;
        return head;
    }
}