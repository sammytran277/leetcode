// https://leetcode.com/problems/diameter-of-binary-tree/

public class DiameterOfBinaryTree  {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left, 0);
        int right = maxDepth(root.right, 0);
        
        int diameter = left + right;
        diameter = Math.max(diameter, diameterOfBinaryTree(root.left));
        diameter = Math.max(diameter, diameterOfBinaryTree(root.right));
        
        return diameter;
    }
    
    public int maxDepth(TreeNode root, int currDepth) {
        if (root == null) {
            return currDepth;
        }
        
        int left = maxDepth(root.left, currDepth + 1);
        int right = maxDepth(root.right, currDepth + 1);
        
        return Math.max(left, right);
    }
}