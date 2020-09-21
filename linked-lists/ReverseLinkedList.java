// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList  {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        
        return prevNode;
    }
}