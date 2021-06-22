// https://leetcode.com/problems/univalued-binary-tree/

public class UnivaluedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }   

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }
    
    public boolean isUnivalTree(TreeNode root, int value) {
        if (root == null) {
            return true;
        } else if (root.val != value) {
            return false;
        }
        
        return isUnivalTree(root.left, value) && isUnivalTree(root.right, value);
    }    
}
