// https://leetcode.com/problems/binary-prefix-divisible-by-5/description/
// Binary Prefix Divisible By 5
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int curr = 0;
        for (int x : nums) {
            curr = (curr * 2 + x) % 5;
            res.add(curr == 0);
        }
        return res;
     } 
}