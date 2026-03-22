// https://leetcode.com/problems/daily-temperatures/description/
// Daily Temperatures
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<int[]> st = new Stack<>();

        for(int i= n-1;i>=0;i--){

            if(st.isEmpty()){
                ans[i] = 0;
            }
            else{

                while(!st.isEmpty() && arr[i] >= st.peek()[0]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    ans[i] = st.peek()[1] - i;
                }
                else ans[i] = 0;
                

            }
            st.push(new int[]{arr[i] , i});
        }
        return ans;
        
        
    }
}