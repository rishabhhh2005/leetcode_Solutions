// https://leetcode.com/problems/minimum-window-substring/
// Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {

        // Agar s chhota hai t se, to possible hi nahi
        if (s.length() < t.length()) return "";

        // Map banaya to store frequency of characters of t
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        // count = kitne required characters abhi tak match ho chuke hain
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Right pointer window ko expand karega
        while (right < s.length()) {

            char curr = s.charAt(right);

            // Agar current char t ka part hai
            if (map.containsKey(curr)) {

                // Agar is character ki abhi bhi zarurat thi
                if (map.get(curr) > 0) {
                    count++; // ✅ ek required character mil gaya
                }

                // Har case mein frequency kam kar denge
                map.put(curr, map.get(curr) - 1);
            }

            right++; // window expand

            // Jab saare required characters mil jaayein
            while (count == t.length()) {

                // Current window ka size check
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // Ab window ko left se shrink karenge
                char leftChar = s.charAt(left);

                // Agar left char t ka part hai
                if (map.containsKey(leftChar)) {

                    // Frequency wapas badhao
                    map.put(leftChar, map.get(leftChar) + 1);

                    // Agar frequency positive ho gayi
                    // matlab ek required char window se nikal gaya
                    if (map.get(leftChar) > 0) {
                        count--; // ❌ ek required character kam ho gaya
                    }
                }

                left++; // window shrink
            }
        }

        // Agar koi valid window nahi mili
        if (minLen == Integer.MAX_VALUE) return "";

        // Minimum window substring return karo
        return s.substring(start, start + minLen);
    }
}
