// https://leetcode.com/problems/invert-binary-tree/

public class InvertBinaryTree 
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) 
    {
        if (root == null)
            return root;
        else
            invert(root);
        
        return root;
    }
    
    public void invert(TreeNode root) 
    {
        if (root == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
            
        invert(root.left);
        invert(root.right);
    }
}