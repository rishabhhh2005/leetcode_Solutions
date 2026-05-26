// https://leetcode.com/problems/jump-game-vii/?envType=daily-question&envId=2026-05-26
// Jump Game VII
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // We can try BFS 
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);

        // pointer for optimization
        int farthest =0;

        while(!q.isEmpty()){

            int currIdx = q.poll();

            if(currIdx == n-1) return true;

            // we need to move from here 
            // the condition  is we need to jump btw min and max 
            // so we have to try all jumps and the jump which satisfy we will add it in queue
            //also we need to keep a farthest pointer so that we avoid trying useless jumps which are already covered somewhere
            int start = Math.max(farthest, currIdx + minJump);
            int end = currIdx + maxJump;
            
            for(int i= start; i<=end;i++){
                
                if(i<n && s.charAt(i) == '0') q.offer(i);
            }

            farthest = end+1;
        }
        return false;
        
    }
}