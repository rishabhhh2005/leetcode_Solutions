// https://leetcode.com/problems/binary-tree-right-side-view/description/
// 199. Binary Tree Right Side View
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    //level order traversal  + return last
    List<Integer> res = new ArrayList<>();
    if(root == null) return res;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()){
        int size = q.size();
        List<Integer>level = new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode curr = q.poll();
            level.add(curr.val);
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }
        res.add(level.get(level.size()-1));
    }
        
        return res;
    }
}
