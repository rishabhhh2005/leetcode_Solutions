// https://leetcode.com/problems/validate-binary-search-tree/description/
// Validate Binary Search Tree
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    public boolean recursion (TreeNode root , long leftRange , long rightRange){
        if(root ==null) return true;
        if(root.val <= leftRange || root.val >= rightRange) return false;

        boolean left = recursion(root.left, leftRange , root.val);
        boolean right = recursion(root.right , root.val, rightRange);
        return left && right;

    }
}
