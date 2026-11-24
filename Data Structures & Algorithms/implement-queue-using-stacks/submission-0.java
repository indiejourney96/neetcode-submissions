class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        // Transfer elements only when stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();        
    }
    
    public int peek() {
        // Transfer elements only when stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();        
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// Operation	Time complexity	Explanation
// push()	    O(1)	        Push into stack1
// pop()	    Amortized O(1)	Each element transfers at most once
// peek()	    Amortized O(1)	Transfers only when stack2 is empty
// empty()	    O(1)	        Check both stacks

// Space complexity: O(n) — both stacks collectively store up to n elements.