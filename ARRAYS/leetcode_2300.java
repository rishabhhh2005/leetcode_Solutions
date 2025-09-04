                                // LeetCode 2300 - Successful Pairs of Spells and Potions
                                // https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        
        int[] result = new int[spells.length];
        int s = spells.length;
        int p = potions.length;
        Arrays.sort(potions);
        int idx=0;
        for(int i=0;i<s;i++){
          
            //binnary searching here
            long curr_spell =(long)spells[i];
            int low =0;
            int high =p-1;
            int success_index = potions.length;

            while(low<=high){
                int mid = low + (high-low)/2;

                if( curr_spell * (long)potions[mid] >= success){
                    success_index=mid;
                    high =mid-1;
                }
                else{
                    low=mid+1;
                }
                


            }
            int totalpairs = potions.length-success_index;
            result[idx++] = totalpairs;
        }

        return result;
        
    }
}