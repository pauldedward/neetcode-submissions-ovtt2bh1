class Solution {
    public int maxSubArray(int[] nums) {
    int cur = nums[0];   // best subarray ending here
    int res = nums[0];   // best seen overall

    for (int i = 1; i < nums.length; i++) {
        cur = Math.max(nums[i], cur + nums[i]);
        res = Math.max(res, cur);
    }
    return res;
}

}
