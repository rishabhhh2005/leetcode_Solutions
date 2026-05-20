// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2026-05-20
// Find the Prefix Common Array of Two Arrays
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] freq = new int[n+1];
        int count=0; 
        for(int i=0;i<n;i++){

            freq[A[i]]++;
            freq[B[i]]++;

            if(A[i] == B[i]) count++;
            else{
                if(freq[A[i]] ==2) count++;
                if(freq[B[i]] == 2) count++;
            }

            res[i] = count;
        }
        return res;
        
    }
}