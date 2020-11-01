// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

public class ConvertBinaryNumberInALinkedListToInteger {
    class ListNode {
        int val;
        ListNode next;
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode currNode = head;
        while (currNode != null) {
            sb.append(currNode.val);
            currNode = currNode.next;
        }
        
        return Integer.parseInt(sb.toString(), 2);
    }
}