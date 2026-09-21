class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //include the same number
        //include the next number
        //do not include this number
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, target, 0, res, subset, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int index, List<List<Integer>> res, List<Integer> subset, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(index >= nums.length || sum > target) {
            return;
        }
        subset.add(nums[index]);
        sum += nums[index];
        dfs(nums, target, index, res, subset, sum);
        subset.remove(subset.size() - 1);
        sum -= nums[index];
        dfs(nums, target, index + 1, res, subset, sum);
    }
}
