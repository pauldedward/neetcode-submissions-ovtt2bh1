class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        /*
        1,2,2,3
                    [1]                    [] 
              [1,2]         [1]         []     [2]
        [1,2,2]   [1,2]  [1,2] [1]    [][2]
        */
        backtrack(nums, 0, subset, res);
        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if(index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[index]);
        backtrack(nums, index + 1, subset, res);
        subset.remove(subset.size() - 1);
        while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        backtrack(nums, index + 1, subset, res);
    }
}
