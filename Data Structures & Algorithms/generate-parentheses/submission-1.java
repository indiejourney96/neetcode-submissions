class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        dfs(n, 0, 0, cur, result);
        return result;
    }

    public void dfs(int n , int open, int close, StringBuilder cur, List<String> result){
        if (cur.length() == 2*n){
            result.add(cur.toString());
            return ;
        }

        if (open < n){
            cur.append('(');
            dfs(n, open + 1, close, cur, result);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open){
            cur.append(')');
            dfs(n, open, close + 1, cur, result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
