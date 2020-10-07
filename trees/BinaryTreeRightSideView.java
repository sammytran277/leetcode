// https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.*;

public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int N = q.size();
            TreeNode currNode = null;
            for (int i = 0; i < N; i++) {
                currNode = q.pollFirst();
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            result.add(currNode.val);
        }
        
        return result;
    }
}