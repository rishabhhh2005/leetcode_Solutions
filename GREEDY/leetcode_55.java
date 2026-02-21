// https://leetcode.com/problems/jump-game/description/
//  Jump Game
class Solution {
    public boolean canJump(int[] nums) {
        int n  = nums.length;
        int goal = n-1;

        for(int index = n-2;index>=0;index--){
            if(index + nums[index] >= goal){
                goal = index;
            }
        }

        return goal == 0;
        
    }
}
