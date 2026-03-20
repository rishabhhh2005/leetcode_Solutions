// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
// Lowest Common Ancestor of a Binary Search Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if( root == null || root.val == p.val || root.val ==  q.val ) return root;

        TreeNode left = lowestCommonAncestor(root.left ,p ,q);
        TreeNode right = lowestCommonAncestor(root.right ,p , q);

        
        if(left == null ) return right;
         if( right == null) return left;
         return root;

        
    }
}