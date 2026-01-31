// https://leetcode.com/problems/jump-game/description/
//  Jump Game
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        int  n = nums.length;
        int targetIndex = n-1; 
        int p =n-2;
        
        while(p>=0){
            
            if(p ==0 && p + nums[p] >= targetIndex) return true;
           
            if(p + nums[p] >= targetIndex){
                targetIndex = p;
                p--;
              
                continue;
            }
            p--;
        }
        return false;
        
    }
}