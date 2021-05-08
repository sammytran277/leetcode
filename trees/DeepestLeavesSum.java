// https://leetcode.com/problems/deepest-leaves-sum/ 

import java.util.*;

public class DeepestLeavesSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int n = q.size();
            sum = 0;
            
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();
                sum += currNode.val;
                
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        
        return sum;
    }    
}
