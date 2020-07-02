// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversalII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Same as Level Order Traversal I, but insert the level at index 0
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.addFirst(root);
        
        while (q.size() != 0) {
            int n = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.pollFirst();
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
                level.add(currNode.val);
            }
            
            levels.add(0, level);
        }
        
        return levels;
    }
}