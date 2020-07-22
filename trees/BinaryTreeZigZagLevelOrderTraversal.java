// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeZigZagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Iterative BFS, get each level, reverse odd levels
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)
            return levels;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        
        // Idea is to get each level and reverse the odd ones
        int parity = 0;
        while (q.size() != 0) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            
            // Remove all nodes from this particular level
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.pollFirst();
                
                // Add left child to queue
                if (currNode.left != null)
                    q.addLast(currNode.left);
                
                // Add right child to queue
                if (currNode.right != null)
                    q.addLast(currNode.right);
                
                level.add(currNode.val);
            }
            
            // Reverse the level if this is an odd level
            if (parity % 2 != 0)
                Collections.reverse(level);

            levels.add(level);
            parity++;
        }
        
        return levels;
    }
}