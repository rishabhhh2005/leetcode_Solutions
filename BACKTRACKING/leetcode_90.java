// https://leetcode.com/problems/subsets-ii/
// Subsets II
class Solution {
      List<List<Integer>> res=  new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length ==0 ) return new ArrayList<>();
    Arrays.sort(nums);
        backtrack(0, nums , new ArrayList<>());
        return res;

        
    }
    public void backtrack(int index , int[] nums  , List<Integer> curr){

        if(index == nums.length){

            if(!res.contains(curr))res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]); // add
        backtrack(index+1, nums,curr);
        curr.remove(curr.size()-1);
        backtrack(index+1 , nums , curr); // remove
    }
}
