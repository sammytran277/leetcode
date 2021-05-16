// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/ 

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }   
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();

        inorder(root1, nums1);
        inorder(root2, nums2);
        
        List<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        while (i < nums1.size() || j < nums2.size()) {
            if (i == nums1.size()) {
                res.add(nums2.get(j++));
            } else if (j == nums2.size()) {
                res.add(nums1.get(i++));
            } else if (nums1.get(i) <= nums2.get(j)) {
                res.add(nums1.get(i++));
            } else {
                res.add(nums2.get(j++));
            }
        }
        
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root != null) {
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }
    }
}    
