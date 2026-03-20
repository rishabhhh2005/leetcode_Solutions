// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// Convert Sorted Array to Binary Search Tree
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return buildTree(0,n-1, nums);
            
    }
    public TreeNode buildTree(int left, int right , int[] nums){

        if(left > right) return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(left , mid-1, nums);
        root.right = buildTree(mid +1, right , nums);

        return root;


    }
}