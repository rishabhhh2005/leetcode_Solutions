// https://leetcode.com/problems/minimum-common-value/?envType=daily-question&envId=2026-05-20
// Minimum Common Value
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int p1 =0;
        int p2 =0;

        while( p1 <nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]) return nums1[p1];
            else{
                if(nums1[p1] < nums2[p2]) p1++;
                else p2++;
            }
        }

        return -1;
        
    }
}