// https://leetcode.com/problems/weighted-word-mapping/?envType=daily-question&envId=2026-06-13
// Weighted Word Mapping
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();

        for( String word : words){
            int sum =0;
            for(char c : word.toCharArray()){
                // index 
                int index = c-97;
                sum +=weights[index] ;
            }

            // do modulo
            sum = sum%26;
            char desired = (char) (122-sum);

            res.append(desired);
        }
        return res.toString();

        
    }
}