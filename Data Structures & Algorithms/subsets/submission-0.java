class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subsets = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, subsets, res);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> subsets, List<List<Integer>> res) {
        if(index >= nums.length) {
            res.add(new ArrayList<>(subsets));
            return;
        }
        subsets.add(nums[index]);
        dfs(nums, index + 1, subsets, res);
        subsets.remove(subsets.size() - 1);
        dfs(nums, index + 1, subsets, res);
    }
} 
