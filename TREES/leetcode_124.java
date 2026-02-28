// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// Binary Tree Maximum Path Sum
class Solution {
    int maxSum;   // global variable jo overall maximum path sum store karega

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;  // initially smallest value se start
        solve(root);                 // DFS call
        return maxSum;               // final answer
    }

    public int solve(TreeNode root){
        if(root == null) return 0;   // agar node null hai to sum = 0

        int left = solve(root.left);   // left subtree ka max path
        int right = solve(root.right); // right subtree ka max path

        // case1: left + root + right (poora V shape path)
        int case1 = left + right + root.val;

        // case2: root + max(left, right) (ek side continue karenge)
        int case2 = Math.max(left, right) + root.val;

        // case3: sirf current node
        int case3 = root.val;

        // global max update kar rahe hain
        maxSum = Math.max(maxSum , 
                  Math.max(case1, Math.max(case2, case3)));

        // parent ko sirf ek side ka best path return karenge
        return Math.max(case2 , case3);
    }
}