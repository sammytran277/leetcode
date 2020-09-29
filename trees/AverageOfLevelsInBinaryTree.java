// https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) {
            return averages;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() != 0) {
            double sum = 0;
            int N = q.size();
            for (int i = 0; i < N; i++) {
                TreeNode currNode = q.pollFirst();
                sum += currNode.val;
                
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            averages.add(sum / N);
        }
        
        return averages;
    }
}