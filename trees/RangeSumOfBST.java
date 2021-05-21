// https://leetcode.com/problems/range-sum-of-bst/

public class RangeSumOfBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }   

    private int sum;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }
    
    public void dfs(TreeNode root, int low, int high) {
        if (root != null) {
            if (low <= root.val && root.val <= high) {
                sum += root.val;
            }

            if (root.val > low) {
                dfs(root.left, low, high);
            }
            
            if (root.val < high) {
                dfs(root.right, low, high);
            }
        }
    }
}
