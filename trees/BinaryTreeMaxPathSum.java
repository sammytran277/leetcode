// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class BinaryTreeMaxPathSum  {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }
    
    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxLeft = Math.max(findMax(root.left), 0);
        int maxRight = Math.max(findMax(root.right), 0);
        maxSum = Math.max(maxSum, root.val + maxLeft + maxRight);
        
        return root.val + Math.max(maxLeft, maxRight);
        
    }
}