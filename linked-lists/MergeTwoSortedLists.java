// https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { 
            this.val = val; 
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                currNode.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                currNode.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            
            currNode = currNode.next;
        }
        
        return dummy.next;
    }    
}
