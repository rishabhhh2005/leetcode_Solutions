// https://leetcode.com/problems/min-stack/description/
// Min Stack    
class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(min.isEmpty() || val <= min.peek()) min.push(val);
        st.push(val);
        
    }
    
    public void pop() {
        int val = st.pop();
         if(val == min.peek()) min.pop();
         return;
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return min.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */