// https://leetcode.com/problems/implement-stack-using-queues/
//225. Implement Stack using Queues

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1=q2;
        q2=temp;
        
    }
    
    public int pop() {
        return q1.poll();
        
    }
    
    public int top() {
        return q1.peek();
        
    }
    
    public boolean empty() {
        return (q1.isEmpty() && q2.isEmpty());
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */