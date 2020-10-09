// https://leetcode.com/problems/path-sum-iii/

public class PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        int a = dfs(root, sum);
        int b = pathSum(root.left, sum);
        int c = pathSum(root.right, sum);
        
        return a + b + c;
    }
    
    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        int a = (root.val == sum) ? 1 : 0;
        int b = dfs(root.left, sum - root.val);
        int c = dfs(root.right, sum - root.val);

        return a + b + c;               
    }
}