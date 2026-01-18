// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//  Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r =0;
        Map<Character, Integer> map = new HashMap<>();
        int maxlen =0;
        while(r <s.length()){
            char currentchar = s.charAt(r);
            if(map.containsKey(currentchar)){
                int pos = map.get(currentchar);
                l = Math.max(l,pos+1); // because there can be a situation where pos +1  can be lesser than l and l can move backward if we just do pos+1 so a safety check
                
            }
            map.put(currentchar , r);
            int windowlen =r-l +1;
            maxlen = Math.max(maxlen, windowlen);
            r++;

        }
        return maxlen;
        
    }
}