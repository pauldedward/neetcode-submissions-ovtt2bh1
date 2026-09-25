class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        generatePermutations(nums, used, current, res);
        return res;
    }

    public void generatePermutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> res) {
        if(current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        
        for(int index = 0; index < nums.length; index++) {
            if(used[index]) {
                continue;
            }
            used[index] = true;
            current.add(nums[index]);
            generatePermutations(nums, used, current, res);
            current.remove(current.size() - 1);
            used[index] = false;
        }
    }
}
