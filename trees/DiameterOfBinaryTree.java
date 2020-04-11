// https://leetcode.com/problems/diameter-of-binary-tree/

import java.util.Stack;

public class DiameterOfBinaryTree 
{
    public class TreeNode 
    {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    // Recursively calculate the max depth starting from a given node
    public int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;
        
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        
        if (leftDepth > rightDepth)
            return leftDepth + 1;
        else
            return rightDepth + 1;
    }
    
    /* Calculate diameter by realizing it is equal to the sum of 
       the max depth of the left and right of a tree */
    public int diameterOfBinaryTree(TreeNode root) 
    {
        int maxDiameter = 0;
        Stack<TreeNode> nodesToVisit = new Stack<TreeNode>();
        nodesToVisit.push(root);
        
        TreeNode currNode;
        while (!nodesToVisit.empty())
        {
            currNode = nodesToVisit.pop();
            if (currNode != null)
            {
                maxDiameter = Math.max(maxDiameter, maxDepth(currNode.left) + maxDepth(currNode.right));
                nodesToVisit.push(currNode.right);
                nodesToVisit.push(currNode.left);
            }
        }
        
        return maxDiameter;
    }
}