// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class BinaryTreeMaxPathSum 
{
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        helper(root);
        return max;
    }
    
    int helper(TreeNode root) 
    {
        if (root == null) 
            return 0;
        
        // Returns the best path from each child, or 0 if it is better to not take that path
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        
        // Updates the global max if taking all three nodes leads to a better max
        max = Math.max(max, root.val + left + right);
        
        return root.val + Math.max(left, right);
    }
}