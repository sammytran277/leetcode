// https://leetcode.com/problems/reorder-list/

public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        
        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half and then merge
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = slow.next;
            slow = temp;
        }
        
        fast.next = null;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        return prevNode;
    }
}