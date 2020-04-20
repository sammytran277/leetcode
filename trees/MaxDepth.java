// https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class MaxDepth 
{
    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) 
    {
        int height = 0;

        if (root == null)
            return height;

        return preorder(root, height);
    }

    public int preorder(TreeNode currNode, int currHeight)
    {
        if (currNode != null)
        {
            int leftHeight = preorder(currNode.left, currHeight + 1);
            int rightHeight = preorder(currNode.right, currHeight + 1);

            return (leftHeight > rightHeight) ? leftHeight : rightHeight;
        }

        return currHeight;
    }
}