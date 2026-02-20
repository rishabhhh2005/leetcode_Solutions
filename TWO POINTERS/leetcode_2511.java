// https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/description/
// Maximum Enemy Forts That Can Be Captured 
class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length;
    // idea is to traverse until we reach a opposite fort and compare maxzeroes
        int x =0;
        int max =0;
        while(x < n && forts[x] == 0) x++;
        int zeroes =0;
        int prevNonzero = x;
        for(int  i =x+1 ;i <n ;i++){
            if(forts[i]  != 0){
                //either 1 or -1 
                if(forts[i] == -forts[prevNonzero]){
                    max = Math.max(max, zeroes);        
                }  
                prevNonzero = i;
                zeroes=0; 
            }
            else zeroes++;

        }
        return max;
        
    }
}