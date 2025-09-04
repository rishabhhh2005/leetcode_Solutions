//                                           LeetCode 187: Repeated DNA Sequences
//                                           https://leetcode.com/problems/repeated-dna-sequences/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        if(s.length() <10) return new ArrayList<>();

        for(int i=0;i<=s.length()-10;i++){
            String curr = s.substring(i,i+10);

            if(seen.contains(curr)){
                repeated.add(curr);
            }
            else{
                seen.add(curr);
            }
        }

        return new ArrayList<>(repeated);
        
    }
}