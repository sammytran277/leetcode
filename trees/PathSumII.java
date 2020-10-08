// https://leetcode.com/problems/path-sum-ii/

import java.util.*;

public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>());
        return result;
    }
    
    public void dfs(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }
        
        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            result.add(path);
        }
        
        dfs(root.left, sum, new ArrayList<>(path));
        dfs(root.right, sum, new ArrayList<>(path));
    }
}