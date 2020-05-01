// LeetCoding Challenge Day 30

public class ValidSequenceFromRootToLeaf 
{
    public class TreeNode 
    {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public boolean isValidSequence(TreeNode root, int[] arr) 
    {
        return isValidSequence(root, arr, 0);
    }
    
    // Idea is to use a pointer to keep track of what values in the target we're seen
    public boolean isValidSequence(TreeNode root, int[] target, int i) 
    {
        if (root != null && i < target.length) 
        {
            /* Stop the search when i != 0, otherwise we could miss 
               branches that could have the sequence */
            if (root.val == target[i])
                i++;
            else if (i != 0)
                return false;
            
            // 
            if (i == target.length && root.left == null && root.right == null)
                return true;

            return isValidSequence(root.left, target, i) || isValidSequence(root.right, target, i);
        }
        
        return false;
    }
}