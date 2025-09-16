class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer>current = new ArrayList<>();
        backtrack(0, nums ,current,result);
        return result;
        
    }

    public void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        
        result.add(new ArrayList<>(current));

      
        for (int i = index; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);

            // Move to the next element
            backtrack(i + 1, nums, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}