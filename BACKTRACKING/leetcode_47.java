// https://leetcode.com/problems/permutations-ii/description/
// Permutations II
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    boolean[] used ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        used = new boolean[nums.length];
        helper(0, new ArrayList<>());
        return res;
        
    }
    public void helper(int index, List<Integer> curr){
        if(curr.size() == nums.length){ res.add(new ArrayList<>(curr)); return;}
        
        for(int i=0;i<nums.length;i++){
            
            if(used[i]) continue;

            if( i>0 && nums[i] ==  nums[i-1] && !used[i-1]) continue;
            curr.add(nums[i]);
            used[i] = true;

            helper(index+1, curr);

            curr.remove(curr.size()-1);
            used[i] = false;
            
        }
    }
}