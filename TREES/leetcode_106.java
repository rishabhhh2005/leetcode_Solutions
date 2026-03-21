// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Construct Binary Tree from Inorder and Postorder Traversal
class Solution {
    int postIndex;
    int[] in;
    int[] post;
    int n;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.post = postorder;
        this.in = inorder;
        this.n = in.length;
        postIndex = n-1;
        return helper(0,n-1);
    }
    public TreeNode helper(int left , int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(post[postIndex--]);
        int index= 0;
        while(index < n){
            if(in[index] == root.val) break;
            index++;
        }

        
        root.right = helper(index+1 , right);
        root.left = helper(left , index-1);
        return root;
    }
}