class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, res, combo);
        return res;
    }

    public void dfs(int[] candidates, int index, int sum, int target, List<List<Integer>> res, List<Integer> combo) {
        if(sum == target) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if(index >= candidates.length || sum > target) {
            return;
        }
        
        combo.add(candidates[index]);
        dfs(candidates, index + 1, sum + candidates[index], target, res, combo);
        combo.remove(combo.size() - 1);
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index = index + 1;
        }
        dfs(candidates, index + 1, sum, target, res, combo);
    }
}
