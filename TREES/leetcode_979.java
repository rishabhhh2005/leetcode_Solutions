// https://leetcode.com/problems/distribute-coins-in-binary-tree/
// Distribute Coins in Binary Tree
class Solution {
    int moves=0;
    public int distributeCoins(TreeNode root) {
        // AT EVERY NODE WE MUST DECIEDE -> 
        // LEFT  SUB TREE ME KITNE NODES HAI RIGHT ME KITNE H AND KHUD PE KITNE H   
        dfs(root);  
        return moves;
    }
    public int dfs(TreeNode node){
        if(node == null) return 0;
        int leftBalance = dfs(node.left);
        int rightBalance = dfs(node.right);
        moves+= Math.abs(leftBalance) + Math.abs(rightBalance) + node.val -1;
         // -1 because ek coin vo khud ke liye rkhega

        return leftBalance + rightBalance + node.val -1;
    }
}