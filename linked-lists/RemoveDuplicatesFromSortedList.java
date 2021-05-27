// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesFromSortedList {
    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            while (currNode.next != null && currNode.val == currNode.next.val) {
                currNode.next = currNode.next.next;
            }
            
            currNode = currNode.next;
        }
        
        return head;
    }    
}