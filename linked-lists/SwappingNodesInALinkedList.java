// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

public class SwappingNodesInALinkedList {
    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 1; i < k; i++) {
            p1 = p1.next;
        }
        
        ListNode reversedHead = reverse(head);
        ListNode p2 = reversedHead;
        for (int i = 1; i < k; i++) {
            p2 = p2.next;
        }

        swap(p1, p2);
        
        return reverse(reversedHead);
    }
    
    public ListNode reverse(ListNode head) {        
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        return prevNode;
    }
    
    public void swap(ListNode n1, ListNode n2) {
        if (n1 == n2) {
            return;
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}