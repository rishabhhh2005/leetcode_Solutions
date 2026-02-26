// https://leetcode.com/problems/decode-ways/
// Decode Ways

class Solution {
    Map<String , Character> map = new HashMap<>();
    Integer[]dp;

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        for (int i = 1; i <= 26; i++)   map.put(String.valueOf(i), (char) ('A' + i - 1)); // build char Map
        dp= new Integer[s.length()];
        return recursion(0, new StringBuilder(), s);
    }

    public int recursion(int index, StringBuilder curr, String s) {
        if (index == s.length()) return 1; // valid
        if (s.charAt(index) == '0') return 0 ; //  If starts with 0

        if(dp[index] != null) return dp[index];

        int way1=0;  //  Take 1
        String one = s.substring(index, index + 1);
        if (map.containsKey(one)) {
            curr.append(map.get(one));
            way1 =recursion(index + 1, curr, s);
            curr.deleteCharAt(curr.length() - 1);  // backtrack
        }

         int way2=0;// Take 2  
        if (index + 1 < s.length()) {
            String two = s.substring(index, index + 2);
            if (map.containsKey(two)) {
                curr.append(map.get(two));
                way2 =recursion(index + 2, curr, s);
                curr.deleteCharAt(curr.length() - 1);  // backtrack
            }
        }

        return dp[index] = way1 + way2;
    }
}