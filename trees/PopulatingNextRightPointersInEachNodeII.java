// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.*;

public class PopulatingNextRightPointersInEachNodeII {
    public class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int N = q.size();
            for (int i = 0; i < N; i++) {
                Node currNode = q.pollFirst();
                if (i != N - 1) {
                    currNode.next = q.peekFirst();
                }
                
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        
        return root;
    }
}