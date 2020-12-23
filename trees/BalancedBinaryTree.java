// https://leetcode.com/problems/balanced-binary-tree/

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else if (Math.abs(height(root.left, 1) - height(root.right, 1)) > 1) {
            return false;
        } else if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }

        return true;
    }
    
    public int height(TreeNode root, int currHeight) {
        if (root == null) {
            return currHeight - 1;  
        }
        
        int leftHeight = height(root.left, currHeight + 1);
        int rightHeight = height(root.right, currHeight + 1);
        
        return Math.max(leftHeight, rightHeight);
    }
}