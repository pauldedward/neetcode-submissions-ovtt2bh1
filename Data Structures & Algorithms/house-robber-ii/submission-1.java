class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[][] cache = new int[2][nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[0][i] = -1;
            cache[1][i] = -1;
        }
        return Math.max(topDown(nums, 0, 1, cache),topDown(nums, 1, 0, cache));
    }

    public int topDown(int[] nums, int index, int flag, int[][] cache) {
        if(index >= nums.length || (flag == 1 && index == nums.length - 1)) {
            return 0;
        }

        if(cache[flag][index] != -1) {
            return cache[flag][index];
        }

        cache[flag][index] = Math.max(
            nums[index] + topDown(nums, index + 2, flag, cache),
            topDown(nums, index + 1, flag, cache)
        );
        
        return cache[flag][index];
    }
}
