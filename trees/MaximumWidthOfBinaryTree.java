// https://leetcode.com/problems/maximum-width-of-binary-tree/

import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // Idea is to do a level order traversal, removing leading/trailing nulls
        while (q.size() != 0) {
            if (q.getFirst() == null) {
                q.removeFirst();
            } else if (q.getLast() == null) {
                q.removeLast();
            } else {
                int N = q.size();
                int width = 0;
                for (int i = 0; i < N; i++) {
                    TreeNode node = q.pollFirst();
                    if (node != null) {
                        q.addLast(node.left);
                        q.addLast(node.right);   
                    } else {
                        q.addLast(null);
                        q.addLast(null);
                    }
                    
                    width++;
                }
                
                maxWidth = Math.max(width, maxWidth);
            }
        }
        
        return maxWidth;
    }
}