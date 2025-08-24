//                                                             389. Find the Difference
//                                                 https://leetcode.com/problems/find-the-difference/description/
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.isEmpty()) return t.charAt(0);
        Map<Character, Integer> map = new HashMap<>();

        for( char c :  s.toCharArray()){
            map.put(c , map.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c) || map.get(c) <=0) return c;
            map.replace(c , map.get(c)-1);
        }
        return ' ';
    }
}