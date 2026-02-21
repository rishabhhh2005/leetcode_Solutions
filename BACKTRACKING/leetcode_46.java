// https://leetcode.com/problems/permutations/description/
// Permutations
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        rec(new ArrayList<>(),nums);
        return res;
    }
    public void rec(List<Integer> curr , int[] nums){
        if(curr.size() ==  nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        // at every index we check if that is not present add it and move
        // if it is present then it's next elems turn for that seat
        // also dont forget to remove the curr seat elem for others to get chance too
        //Pure Bscktracking
        for(int i=0;i<nums.length;i++){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                rec(curr,nums);
                curr.remove(curr.size()-1);
            }
           
        }

    }
}
