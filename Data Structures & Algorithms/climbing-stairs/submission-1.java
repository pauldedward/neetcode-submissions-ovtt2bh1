class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return dfs(n, 0, cache);
    }

    public int dfs(int top, int step, int[] cache) {
        if(step > top) {
            return 0;
        }
        if(cache[step] != 0) {
            return cache[step];
        }
        if(step == top) {
            return 1;
        }
        return cache[step] = dfs(top, step + 1, cache) + dfs(top, step + 2, cache);
    }
}
