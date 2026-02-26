// https://leetcode.com/problems/hand-of-straights/description/
// Hand of Straights
class Solution {
    public boolean isNStraightHand(int[] hand, int gsize) {
        if(hand.length % gsize != 0) return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : hand) map.put(x , map.getOrDefault(x,0)+1);
        int currsize=0;

        for(int num : hand){
            if(map.get(num) == 0) continue; // already used

            for(int k =0 ; k< gsize;k++){
                int curr = num + k;
                if(map.getOrDefault(curr,0) == 0) return false;
                map.put(curr, map.get(curr)-1);

            }
        }
        return true;
    }
}
