// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/
// Maximum Distance Between a Pair of Values
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int n1 = nums1.length;   int n2 = nums2.length;
        int i=0; int j=0;
        int max =0;
        while(i <n1 && j <n2){
            if(nums1[i] <= nums2[j]){
                max = Math.max(max, (j-i));
                j++;
            }
            else{
                i++;
                while (i>j) j++;
            }
        }
        return max;
        
    }
}