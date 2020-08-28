// https://leetcode.com/problems/palindrome-linked-list/

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
        
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