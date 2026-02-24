// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
// Sum of Root To Leaf Binary Numbers
class Solution {
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        if( root == null) return 0;
        
        dfs(root, new StringBuilder());
        return sum;
        
    }
    public void dfs(TreeNode root , StringBuilder current){
        if(root == null) return;
        current.append(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            sum = sum + convert(current.toString());
            
        }
        else{
        dfs(root.left ,current);
        dfs(root.right,current);}
        current.deleteCharAt(current.length()-1);

    }
    public int convert(String bs){
        if(bs.isEmpty()) return 0;
        return Integer.parseInt(bs, 2);
    }
}