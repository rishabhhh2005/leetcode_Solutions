// https://leetcode.com/problems/partition-labels/description/
// Partition Labels
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        Map<Character , Integer> lastMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            lastMap.put(c ,i);
        }
        int len=0;
        int maxlast =0;
        for(int i=0;i<s.length();i++){
             len++;
            char curr = s.charAt(i);
            maxlast = Math.max(maxlast , lastMap.get(curr));
           
            if(maxlast == i){
                res.add(len);
                len=0;
            }
        }
        return res;
    }
}