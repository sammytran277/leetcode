// https://leetcode.com/problems/linked-list-cycle-ii/

public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;
    }

    // Use Floyd's Tortoise and Hare Algorithm
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow;
            }
        }
        
        return null;
    }
}