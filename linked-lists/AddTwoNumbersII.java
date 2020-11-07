// https://leetcode.com/problems/add-two-numbers-ii/

public class AddTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode l3 = null;
        ListNode currNode = l3;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 == null) ? 0 : l1.val;
            int digit2 = (l2 == null) ? 0 : l2.val;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            
            if (currNode == null) {
                l3 = new ListNode(sum % 10);
                currNode = l3;
            } else {
                currNode.next = new ListNode(sum % 10);
                currNode = currNode.next;
            }
            
            if (l1 != null) {
                l1 = l1.next;
            }
            
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        
        return reverse(l3);
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
}
