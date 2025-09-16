class Solution {
    public List<String> list = new ArrayList<>();
    boolean isLeftTurn = true;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        if(n == 0) return list;
        helper(n ,n , "", list);
        return list;

        
    }

    public void helper(int left ,int right, String prefix , List<String> list){
        if(left > right) return;
        if(left == 0 && right ==0){
            list.add(prefix);
            return;
        }

        if(left >0){
            helper(left-1, right , prefix +"(" , list);
        }
        if(right >0){
            helper(left, right-1, prefix+")", list);
        }
    }
}