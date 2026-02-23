// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// 105. Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int index =0; //index will keep track of ______________________
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i] ,i);
        }

        return dfs(preorder, 0, inorder.length-1);
        
    }
    private TreeNode dfs(int[] pre , int l , int r){
        if(l>r) return null;
       
        int root_val = pre[index++];
        TreeNode root = new TreeNode(root_val);
        int mid = map.get(root_val);

        root.left = dfs(pre ,l,mid-1);
        root.right =dfs(pre,mid+1 , r);

        return root;

    }
}
