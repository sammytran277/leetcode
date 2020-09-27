// https://leetcode.com/problems/rotate-list/

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        int N = 0;
        ListNode currNode = head;
        ListNode endOfSubList = null;
        while (currNode != null) {
            if (currNode.next == null) {
                endOfSubList = currNode;
            }
            
            currNode = currNode.next;
            N++;
        }
        
        k %= N;
        if (N <= 1 || k == 0) {
            return head;
        }
        
        endOfSubList.next = head;
        currNode = head;
        for (int i = 1; i < N - k; i++) {
            currNode = currNode.next;
        }
        
        ListNode startOfSubList = currNode.next;
        currNode.next = null;
        return startOfSubList;
    }
}