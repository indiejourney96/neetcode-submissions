class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if (s.equals("+")){ //not == because it checks whether both variables 
                //  refer to the same object in memory.
                //  equals() checks whether they contain the same characters. 
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(top + bottom);

            } else if (s.equals("-")){
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom - top); //to take note [15(bottom),3(top)], 15-3

            } else if (s.equals("*")){
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(top*bottom);

            } else if (s.equals("/")){
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom/top); //to take note [15(bottom),3(top)] == 15/3

            } else {
                stack.push(Integer.parseInt(s));
            }
        }
    return stack.peek();
    }
}
