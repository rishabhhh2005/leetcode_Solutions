// https://leetcode.com/problems/balanced-binary-tree/
// Balanced Binary Tree
class Solution {
    int left, right=0;
    public boolean isBalanced(TreeNode root) {
    if(root == null) return true;
    left = calcHeight(root.left);
    right = calcHeight(root.right);

    if(Math.abs(left-right) >1) return false;

    return isBalanced(root.left) && isBalanced(root.right);
    
        
    }

    public int calcHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max( calcHeight(root.left) , calcHeight(root.right));
    }
}