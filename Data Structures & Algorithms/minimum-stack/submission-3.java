class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minTemp;
    
    public MinStack() {
        stack = new Stack<>();
        minTemp = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minTemp.isEmpty() || val <= minTemp.peek()){
            minTemp.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        if (minTemp.peek() ==  top){
            minTemp.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minTemp.peek();
    }
}

