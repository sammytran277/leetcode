// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode currNode = l3;
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;

            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        
        return l3.next;
    }
}