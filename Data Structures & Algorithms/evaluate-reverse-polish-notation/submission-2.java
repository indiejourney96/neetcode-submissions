class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if (s.equals("+")){
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(top + bottom);
            } else if (s.equals("-")){
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom - top);
            } else if (s.equals("*")){
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom * top);
            } else if (s.equals("/")){
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom/top);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();  
    }
}
