// https://leetcode.com/problems/same-tree/submissions/1995049940/?envType=problem-list-v2&envId=oizxjoit
// Same Tree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null) return true;
        if( p == null || q == null) return false;
        if(p.val != q.val) return false;
        boolean leftt = isSameTree(p.left , q.left);
        boolean rightt = isSameTree(p.right, q.right);
        
        return leftt && rightt;
        
    }
}