class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        backtrack(n, 0, 0, cur, res);
        return res;
    }

    public void backtrack(int n, int open, int close, StringBuilder cur, List<String> res){
        // Base case: used all n open and n close parentheses
        if (cur.length() == 2 * n){
            res.add(cur.toString());
            return; 
        }

        // Choice 1: add "(" if we still have open parentheses left
        if (open < n){
            cur.append('('); // choose
            backtrack(n, open + 1, close, cur, res); //explore
            cur.deleteCharAt(cur.length() - 1); //undo
        }

        // Choice 2: add ")" only if it keeps the string valid
        if (close < open){
            cur.append(')');
            backtrack(n, open, close + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

//Backtracking 
//Time:  O(4^n / sqrt(n))
//Space: O(n) auxiliary space

//I use backtracking and build the string one character at a time. At each step, I can add an opening parenthesis if I still have fewer than n opens. I can add a closing parenthesis only if the number of closes is less than opens, so the string stays valid. When the string length reaches 2n, I add it to the result.
