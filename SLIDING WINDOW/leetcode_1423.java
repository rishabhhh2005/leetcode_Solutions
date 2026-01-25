// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// Maximum Points You Can Obtain from Cards

class Solution {
    public int maxScore(int[] cards, int k) {
        // Agar k = 0 ya array empty hai, to score 0 hoga
        if(k == 0 || cards.length == 0) return 0;

        int leftsum = 0;
        int left = 0;

        // Pehle k cards ka sum le rahe hain (sab left se)
        while(left < k){
            leftsum += cards[left];
            left++;
        }

        // Ab left last valid index par aa gaya (k-1)
        left--;

        int n = cards.length;
        int right = n - 1;

        // Initially answer = sirf left se k cards ka sum
        int maxpoints = leftsum;

        int rightsum = 0;

        // Har iteration me:
        // ek card left se hatao
        // ek card right se add karo
        while(left >= 0){

            // Left side ka ek card remove kar rahe hain
            leftsum -= cards[left];
            left--;

            // Right side ka ek card add kar rahe hain
            rightsum += cards[right];
            right--;

            // Har combination ka max calculate karte jao
            maxpoints = Math.max(maxpoints, leftsum + rightsum);
        }

        // Final maximum score return
        return maxpoints;
    }
}
