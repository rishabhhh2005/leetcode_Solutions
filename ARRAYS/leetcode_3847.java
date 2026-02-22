// https://leetcode.com/problems/score-difference-in-game/description/
// 3847. Score Difference in Game
class Solution {
    public int scoreDifference(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
    
        int score1=0;
        int score2=0;

        int ptr=0;
        boolean active1 =true;
        while(ptr <n){
            int currpoints = nums[ptr];

            if(currpoints %2 != 0    ){
                //swap
                if(active1) active1=false;
                else active1 = true;
            }

            if(( ptr!=0 && (ptr+1)%6 == 0)){
                //swap
                if(active1) active1=false;
                else active1 = true;

            }

            if (active1) score1+=currpoints;
            else score2+=currpoints;

            ptr++;
        }
        return score1 - score2;
    }
    
}