// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
//  Binary Tree Preorder Traversal
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
        
        
    }
    public void preorder(TreeNode root){
        if(root ==null) return;
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);

    }
}