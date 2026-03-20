// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Insert into a Binary Search Tree
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // we need to use the property of BST here
        return helper(root,val);
        
    }
    protected TreeNode helper(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(root.val > val) root.left =helper(root.left , val);
        if(root.val < val) root.right =helper(root.right , val);

        return root;
    }
}