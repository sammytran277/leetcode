// https://leetcode.com/problems/reverse-linked-list-ii/

public class ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        
        // conn is the (m - 1)th node before reversing
        // tail is the (m)th node before reversing (last node after reversing)
        ListNode conn = null;
        ListNode tail = head;
        for (int i = 1; i < m; i++) {
            conn = tail;
            tail = tail.next;
        }
        
        ListNode prevNode = conn;
        ListNode currNode = tail;
        for (int i = 0; i <= n - m; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        // Explicitly handle case when m = 1
        if (conn != null) {
            conn.next = prevNode;
        } else {
            head = prevNode;
        }

        tail.next = currNode;
        return head;
    }
}