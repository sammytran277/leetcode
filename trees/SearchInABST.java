// https://leetcode.com/problems/search-in-a-binary-search-tree/

public class SearchInABST {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }
    
    public TreeNode search(TreeNode currNode, int val) {
        if (currNode == null)
            return null;
        else if (currNode.val < val)
            return search(currNode.right, val);
        else if (currNode.val > val)
            return search(currNode.left, val);
        else
            return currNode;
    }
}