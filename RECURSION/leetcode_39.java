// 39. Combination Sum
// https://leetcode.com/problems/combination-sum/description/


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target == 0) return new ArrayList<>();
      

        backtrack(candidates, target , 0 ,new ArrayList<>(),0);
        return result;
        
        
    }

    public void backtrack(int[] candidates , int target ,int startIndex ,List<Integer> currlist , int currsum){
       
        
        if(currsum > target){
            return;
        }

        if(currsum == target){
            result.add(new ArrayList<>(currlist));
        }
        
        for(int i=startIndex ;i < candidates.length;i++){
            currlist.add(candidates[i]);
            backtrack(candidates , target , i , currlist , currsum + candidates[i]);
            currlist.remove(currlist.size()-1);

        }  
    }
}