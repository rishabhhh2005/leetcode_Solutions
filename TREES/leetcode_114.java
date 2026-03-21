// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Flatten Binary Tree to Linked List
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode node) {
        if(node == null) return;

        flatten(node.right); // go to right most 
        flatten(node.left);  // then go to left
        node.right = prev;  
        node.left =null; // then disconnect the left and connect the right 
        prev= node;  // backtracking
    }
      
}