// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
//  Binary Tree Postorder Traversal
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return res;
        
        
    }
    public void postorder(TreeNode root){
        if(root ==null) return;
        postorder(root.left);
        postorder(root.right);
        res.add(root.val);

    }
}