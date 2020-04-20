// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

import java.util.Arrays;

public class SortedArrayToBST 
{
    public class TreeNode 
    {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    // Recursive O(n * logn) solution that builds the tree from the middle 
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        int n = nums.length;
        
        if (n == 0)
            return null;
        
        TreeNode root = new TreeNode(nums[n / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, n / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, (n / 2) + 1, n));
        
        return root;
    }
}