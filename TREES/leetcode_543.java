// https://leetcode.com/problems/diameter-of-binary-tree/description/
// Diameter of Binary Tree
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

      
        int throughRoot = calcdiam(root);
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);

        return Math.max(throughRoot, Math.max(leftDia, rightDia));
    }

    public int calcdiam(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return left + right; 
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
