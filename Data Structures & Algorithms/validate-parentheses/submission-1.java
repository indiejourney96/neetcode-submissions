class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){

            //Opening brackets
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }

            //Closing parenthesis
            else if (c == ')'){
                if (stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }

            //Closing square brackets
            else if (c == ']'){
                if (stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }            
        
            //Closing curly brackets
            else if (c == '}'){
                if (stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }            
        }
        return stack.isEmpty();
    }
}
