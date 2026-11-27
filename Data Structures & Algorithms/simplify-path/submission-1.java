class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String cur : paths) {

            // Go to parent directory
            if (cur.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Ignore empty strings and current directory
            else if (!cur.equals("") && !cur.equals(".")) {
                stack.push(cur);
            }
        }

        // Build the canonical path
        return "/" + String.join("/", stack);
    }
}

// Stack solution
// Complexity	Explanation
// Time     	O(n)
// Space	    O(n)

// - Splitting the path takes O(n).
// - Processing all components takes O(n) overall.
// - Building the result takes O(n).
// - The list and split array require O(n) space.