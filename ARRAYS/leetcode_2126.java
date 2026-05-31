// https://leetcode.com/problems/destroying-asteroids/?envType=daily-question&envId=2026-05-31
// Destroying Asteroids
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long curr = mass;
        for(int x : asteroids){
            if(curr < x) return false;
            curr = curr+ (long) x;
        }
        return true;
        
    }
}