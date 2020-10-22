// https://leetcode.com/problems/validate-binary-search-tree/

public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        return checkRoot(root, null, null);
    }
    
    public boolean checkRoot(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        } else if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        
        return checkRoot(root.left, min, root.val) && checkRoot(root.right, root.val, max);
    }
}