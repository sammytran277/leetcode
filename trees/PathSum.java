// https://leetcode.com/problems/path-sum/

public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum, 0);    
    }
    
    public boolean dfs(TreeNode root, int sum, int current) {
        if (root == null) {
            return false;
        }
        
        current += root.val;
        if (root.left == null && root.right == null) {
            return current == sum;
        }
        
        boolean left = dfs(root.left, sum, current);
        boolean right = dfs(root.right, sum, current);

        return left || right;
    }
}