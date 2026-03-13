// https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/
// Minimum Number of Seconds to Make Mountain Height Zero
class Solution {
    public long minNumberOfSeconds(int H, int[] workers) {

        // Binary Search on Time
        long low = 1;

        // find slowest worker
        int max = workers[0];
        for(int x : workers) max = Math.max(max, x);

        // worst case: slowest worker alone breaks mountain
        long high = (long)max * H * (H + 1) / 2;

        while(low < high){

            long mid = low + (high - low) / 2;

            if(check(mid, workers, H))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    public boolean check(long time , int[] workers, int height){

        long sum = 0;

        for(int x : workers){

            // max height worker can reduce in given time
            long k = (long)((-1 + Math.sqrt(1 + 8.0 * time / x)) / 2);

            sum += k;

            if(sum >= height)
                return true;
        }

        return false;
    }
}