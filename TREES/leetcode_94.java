// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
//  Binary Tree Preorder Traversal

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
        
        
    }
    public void inorder(TreeNode root){
        if(root ==null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);

    }
}