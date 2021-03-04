// https://leetcode.com/problems/intersection-of-two-linked-lists/

import java.util.*;

public class IntersectionOfTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        
        ListNode currNode = headA;
        while (currNode != null) {
            set.add(currNode);
            currNode = currNode.next;
        }
        
        currNode = headB;
        while (currNode != null) {
            if (set.contains(currNode)) {
                return currNode;
            }
            
            currNode = currNode.next;
        }
        
        return null;
    }
}