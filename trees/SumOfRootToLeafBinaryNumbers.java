// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

public class SumOfRootToLeafBinaryNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int sumRootToLeaf(TreeNode root) {
        return (root != null) ? sumRootToLeaf(root, 0) : 0;
    }
    
    public int sumRootToLeaf(TreeNode root, int sum) {
        sum = (sum << 1) | root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        
        int left = (root.left != null) ? sumRootToLeaf(root.left, sum) : 0;
        int right = (root.right != null) ? sumRootToLeaf(root.right, sum) : 0;
        return left + right;
    }
}