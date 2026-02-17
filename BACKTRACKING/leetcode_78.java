// https://leetcode.com/problems/subsets/
// Subsets
lass Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //generate all subsets by recursion
        recursion(0, new ArrayList<>(), nums);
        return res;
        
        
    }
    public void recursion(int index ,List<Integer> currsubset , int[] nums){
    
        if(index >= nums.length){
            res.add(new ArrayList<>(currsubset));

            return;
        }

        int number = nums[index];
           // include
         currsubset.add(number);
        recursion(index+1, currsubset, nums);
        
        // not include
        currsubset.remove(currsubset.size() - 1);
        recursion(index+1,currsubset, nums);
        return;

    }
}