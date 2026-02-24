// https://leetcode.com/problems/encode-and-decode-strings/
// Encode and Decode Strings
class Solution {
    // we will encode based on " length# "
    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder res = new StringBuilder();
        for(String x : strs){
            int len = x.length();
            res.append(String.valueOf(len) + "#" + x);
        }

        return res.toString();

    }

    public List<String> decode(String str) {

    List<String> res = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {

        int j = i;

        // Step 1: find '#'
        while (str.charAt(j) != '#') {
            j++;
        }

        // Step 2: extract length
        int len = Integer.parseInt(str.substring(i, j));

        // Step 3: move pointer after '#'
        j++;

        // Step 4: extract string
        String word = str.substring(j, j + len);
        res.add(word);

        // Step 5: move pointer ahead
        i = j + len;
    }

    return res;
}
}
