// https://leetcode.com/problems/combination-sum-iii/description/
// Combination Sum III
class Solution {
     List<List<Integer>>res  =new ArrayList<>();
     int k;   int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n ;
        helper(1, new ArrayList<>(), 0);
        return res;
    }
    public void helper(int i, ArrayList<Integer>curr , int currsum  ){
        int size = curr.size();
        if(size == k){
            if(currsum == n) res.add(new ArrayList<>(curr));
            return;
        }
        if(i >9 ) return;

        curr.add(i);
        helper(i+1,curr, currsum +i);
        curr.remove(curr.size()-1);
        helper(i+1,curr, currsum);
    }
}