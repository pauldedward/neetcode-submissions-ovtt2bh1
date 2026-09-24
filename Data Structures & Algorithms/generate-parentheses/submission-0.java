class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, res, sb);
        return res;
    }

    public void dfs(int open, int close, List<String> res, StringBuilder sb) {
        if(open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }
        if(open > 0) {
            sb.append('(');
            dfs(open - 1, close, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close > open) {
            sb.append(')');
            dfs(open, close - 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
