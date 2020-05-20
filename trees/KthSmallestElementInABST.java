// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

import java.util.ArrayList;

public class KthSmallestElementInABST 
{
    public class TreeNode 
    {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    ArrayList<Integer> inOrderValues = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) 
    {
        inOrderTraversal(root);
        return inOrderValues.get(k - 1);
    }
    
    public void inOrderTraversal(TreeNode root) 
    {
        if (root != null) 
        {
            inOrderTraversal(root.left);
            inOrderValues.add(root.val);
            inOrderTraversal(root.right);
        }
    }
}

