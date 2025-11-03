// https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal/
 // Minimum Cost to Make All Characters Equal
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int maxTime = neededTime[0]; 

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
           
                totalTime += Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
               
                maxTime = neededTime[i];
            }
        }
        return totalTime;
    }
}
