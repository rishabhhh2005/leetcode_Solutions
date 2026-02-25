// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
// Substrings of Size Three with Distinct Characters
class Solution { // classical sliding window problem
    public int countGoodSubstrings(String s) {
        int len = s.length();
        int left =0;
        int right =0;
        int count=0;
        Set<Character>set = new HashSet<>();
        while(right < len){
            char curr = s.charAt(right);
            // slide window until we have unique characters in our  window
            while(set.contains(curr)){
                char leftchar = s.charAt(left);
                set.remove(leftchar);
                left++;
            }
            set.add(curr);
            if(set.size() >3){ // if set size increases from 3 .. we must shrink by one 
                char leftchar = s.charAt(left);
                set.remove(leftchar);
                left++;

            }
            if(set.size() == 3) count++;

            right++;
        }
        return count;
        
    }
}