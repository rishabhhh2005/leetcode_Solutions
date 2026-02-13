// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Find All Numbers Disappeared in an Array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //We use our main array to save space complexity
        if(nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) -1;
            if(nums[index]> 0) nums[index] = - nums[index];
        } // we will mark visited elements as minus only once
        // the indexes which are unvisited are not present in the array
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) res.add(i+1);
        }
        return res;  
    }
}