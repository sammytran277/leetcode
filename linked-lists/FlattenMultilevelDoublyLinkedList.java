// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

public class FlattenMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.child == null) {
                currNode = currNode.next;
            } else {
                /*
                
                A---C---NULL
                |
                B---NULL

                Idea is to store C as temp, recursively call flatten on B,
                and then carefully rearrange the pointers to flatten the list
                
                */
                
                Node temp = currNode.next;
                currNode.next = flatten(currNode.child);
                Node lastNode = currNode.child;
                lastNode.prev = currNode;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }
                
                lastNode.next = temp;
                if (temp != null) {
                    temp.prev = lastNode;
                }
                
                currNode.child = null;
            }
        }
        
        return head;
    }
}