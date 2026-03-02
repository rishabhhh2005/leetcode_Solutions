// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// Median of Two Sorted Arrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int totalSize = n1 + n2;
        int idx1 = (totalSize / 2) - 1;
        int idx2 = (totalSize / 2);

        int p1 = 0, p2 = 0;
        int k = 0;

        int elem1 = 0, elem2 = 0;

        // Merge until one array finishes
        while (p1 < n1 && p2 < n2) {
            int val;

            if (nums1[p1] <= nums2[p2]) {
                val = nums1[p1];
                p1++;
            } else {
                val = nums2[p2];
                p2++;
            }

            if (k == idx1) elem1 = val;
            if (k == idx2) elem2 = val;

            k++;
        }

        // Remaining elements of nums1
        while (p1 < n1) {
            int val = nums1[p1];

            if (k == idx1) elem1 = val;
            if (k == idx2) elem2 = val;

            p1++;
            k++;
        }

        // Remaining elements of nums2
        while (p2 < n2) {
            int val = nums2[p2];

            if (k == idx1) elem1 = val;
            if (k == idx2) elem2 = val;

            p2++;
            k++;
        }

        if (totalSize % 2 == 0) {
            return (elem1 + elem2) / 2.0;
        } else {
            return elem2;
        }
    }
}