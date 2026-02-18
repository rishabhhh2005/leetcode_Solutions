// https://leetcode.com/problems/minimum-moves-to-reach-target-score/   
// Minimum Moves to Reach Target Score
class Solution {
    public int minMoves(int target, int maxDoubles) {
        //greedy
        // letsgo from target - > 1
        //divide  - when even 
        // -1  - when odd

        if(maxDoubles == 0) return target -1;
        if(target <= 1) return 0;
        int minsteps =0;
        while(target  >1 && maxDoubles > 0){
            if(target % 2 == 0 ){
                target = target/2;   
                maxDoubles--;
            }
            else target -=1;
            minsteps++;

        }
        return minsteps + target-1;
        
    }
}