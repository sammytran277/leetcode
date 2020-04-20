// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

public class ConstructBSTFromPreorder 
{
    public class TreeNode 
    {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public TreeNode bstFromPreorder(int[] preorder) 
    {   
        return constructBST(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode constructBST(int[] preorder, int start, int end)
    {
        if (start > end)
            return null;
        
        TreeNode root = new TreeNode(preorder[start]);
        
        // Handles array of length 1
        if (start == end)
            return root;
        
        /* Find the first value larger than the root to partition the array 
            into the left (lower than value) and right portion (greater than value) */
        int greater = -1;
        for (int i = start; i <= end; i++)
        {
            if (preorder[i] > root.val)
            {
                greater = i;
                break;
            }
        }
        
        // There is no value greater than the root, so there is no right node
        if (greater == -1)
        {
            root.left = constructBST(preorder, start + 1, end);
            root.right = null;
        }
        else
        {
            root.left = constructBST(preorder, start + 1, greater - 1);
            root.right = constructBST(preorder, greater, end);
        }
        
        return root;
    }
}