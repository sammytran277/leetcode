// https://leetcode.com/problems/reverse-nodes-in-k-group/

public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int N = 0;
        ListNode currNode = head;
        while (currNode != null) {
            N++;
            currNode = currNode.next;
        }
        
        // Reverse (N / k) groups
        ListNode conn = null;
        currNode = head;
        for (int i = 0; i < N / k; i++) {
            // Reverse pointers of k nodes
            ListNode prevNode = null;
            ListNode tail = currNode;
            for (int j = 0; j < k; j++) {
                ListNode nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
            }
            
            // Get the new head after first reversal
            if (i == 0) {
                head = prevNode;
            }
            
            // Attach reversed group to previous group's tail
            if (conn != null) {
                conn.next = prevNode;
            }
            
            conn = tail;
        }
        
        conn.next = currNode;
        return head;
    }
}