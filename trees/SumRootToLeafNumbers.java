// https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, "");
    }
    
    public int dfs(TreeNode currNode, String num) {
        if (currNode == null)
            return 0;
        else if (currNode.left == null && currNode.right == null)
            return Integer.parseInt(num + currNode.val);
        
        StringBuilder sb = new StringBuilder(num);
        sb.append(currNode.val);
        
        return dfs(currNode.left, sb.toString()) + dfs(currNode.right, sb.toString());
    }
}