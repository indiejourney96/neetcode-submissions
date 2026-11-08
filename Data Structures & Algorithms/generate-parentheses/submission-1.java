class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        backtrack(n, 0, 0, cur, res);

        return res;
    }

    public void backtrack(int n, int open, int close, StringBuilder cur, List<String> res){
        if (cur.length() == 2 * n){
            res.add(cur.toString());
            return ;
        }

        if (open < n){
            cur.append('(');
            backtrack(n, open + 1, close, cur,res);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open){
            cur.append(')');
            backtrack(n, open, close + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
