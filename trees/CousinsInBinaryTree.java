// https://leetcode.com/problems/cousins-in-binary-tree/

public class CousinsInBinaryTree 
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int xParent, yParent, xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        if (root.val != x && root.val != y) 
        {
            dfs(root, x, y, 0, 0);
            if (xParent != yParent && xDepth == yDepth)
                return true;
        }
        
        return false;
    }
    
    public void dfs(TreeNode root, int x, int y, int parent, int currDepth) 
    {
        if (root != null) 
        {
            if (root.val == x) 
            {
                xParent = parent;
                xDepth = currDepth;
            } 
            else if (root.val == y) 
            {
                yParent = parent;
                yDepth = currDepth;
            }
            
            dfs(root.left, x, y, root.val, currDepth + 1);
            dfs(root.right, x, y, root.val, currDepth + 1);
        }
    }
}