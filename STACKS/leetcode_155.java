// Min Stack
// https://leetcode.com/problems/min-stack/description/

class MinStack {
    List<Integer> stack = new ArrayList<>();
    Stack<Integer> realstack = new Stack<>();


    public MinStack() {
        
        
    }
    
    public void push(int val) {
        stack.add(val);
        realstack.push(val);
        
        
    }
    
    public void pop() {
        stack.remove(realstack.peek());
        realstack.pop();
    }
    
    public int top() {
        return realstack.peek();
        
    }
    
    public int getMin() {
        return Collections.min(stack);
        
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