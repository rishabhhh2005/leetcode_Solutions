// https://leetcode.com/problems/frog-jump/description/
// Frog Jump

class Solution {
    public boolean canCross(int[] stones) {
        // we can  solve it using dp
        Map<Integer, Set<Integer>  > dp = new HashMap<>();
// we will keep a dp map to store stone -> {jumps required to reach that stone}
//why we are doing this? because we need to try every possible way to reach to last stone
        for(int stone : stones){
            dp.put( stone , new HashSet<>());
        }
        dp.get(0).add(0);

        for(int stone : stones){
            for(int jump : dp.get(stone)){
                for( int jumpDist :  new int[]{jump-1 , jump , jump+1}){

                    if(jumpDist > 0 && dp.containsKey(stone + jumpDist) ){
                        dp.get(stone + jumpDist).add (jumpDist);
                    }
                }

            }
        }
        return !dp.get(stones[stones.length-1]).isEmpty();
        //at the end if we can reach at the last stone we return true
        
    }
}