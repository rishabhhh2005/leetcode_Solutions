// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Remove Duplicates from Sorted Array II
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k=2; // write pointer

        for(int i=2;i<n;i++){
            if(k<n && nums[i] !=nums[k-2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
        
    }
}