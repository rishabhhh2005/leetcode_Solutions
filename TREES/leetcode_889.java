// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
// Construct Binary Tree from Preorder and Postorder Traversal
class Solution {
    int[] pre;
    int[] post;
    int preIndex= 0;
    int n;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.pre = preorder;
        this.post = postorder;
        this.n = pre.length;
        return build(0, n-1);
        
    }
    public TreeNode build(int left , int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        if(left == right) return root;
       
        int val = pre[preIndex];

        int index =left;
        while(post[index]  != val) index++;
// because pre order ke root ka next element post order e dhundenge to uske 
        //left wale sare left subtree me honge
        root.left = build(left , index);
        root.right = build(index+1 , right -1); 
        return root;
    }
}