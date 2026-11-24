class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();        
    }
    
    public void push(int x) {
        // Add the new element to queue2
        queue2.offer(x);

        // Move all existing elements behind the new element
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;        
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
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

// Operation	Time complexity	Explanation
// push()	    O(n)	        Move existing elements
// pop()	    O(1)	        Remove from front
// top()	    O(1)	        Peek at front
// empty()	    O(1)	        Check if queue is empty

// Space complexity: O(n).