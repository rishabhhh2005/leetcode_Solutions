//   https://leetcode.com/problems/combination-sum-ii/description/
// 40. Combination Sum II

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(target ==0 || candidates.length == 0){
              List<List<Integer>> emptyresult = new ArrayList<>();
              return emptyresult;

        };
          Arrays.sort(candidates);
        helper(candidates , 0 ,target , new ArrayList<>(),result);
        return result;
        
    }
    public void helper(int[] candidates , int index , int target , List<Integer> currlist , List<List<Integer>> result)
    {
        if(target==0){
            result.add(new ArrayList<>(currlist));
            return;

        }
        if(index>=candidates.length){
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            currlist.add(candidates[i]);
            
            helper(candidates, i+1, target- candidates[i] , currlist, result);
            currlist.remove(currlist.size()-1);
        }
    }
}