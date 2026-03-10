// https://leetcode.com/problems/range-sum-query-immutable/
// Range Sum Query - Immutable
class NumArray {
    // If we calculate the sum of elements every time sumRange(left, right) is called,
    // it would take O(n) time per query. So we use Prefix Sum

To optimize this, we precompute prefix sums.
    int[] nums;
    int[] prefix;
    public NumArray(int[] nums) {
        this.nums = nums;
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        prefixSum();
        
    }
    public void prefixSum(){
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return prefix[right];
        return prefix[right] - prefix[left-1];
    
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */