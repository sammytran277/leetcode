// https://leetcode.com/problems/symmetric-tree/

public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric (TreeNode a, TreeNode b) {
        if (a == null || b == null)
            return a == null & b == null;
        else if (a.val != b.val)
            return false;
        
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}