// 1899. Merge Triplets to Form Target Triplet
// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean target0 = false;
        boolean target1 = false;
        boolean target2 = false;

        for(int t[] : triplets){
             if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            if(t[0] == target[0]) target0 = true;
            if(t[1] == target[1]) target1 = true;
            if(t[2] == target[2]) target2 = true;
        }
        return target0 && target1 && target2;
        
    }
}
