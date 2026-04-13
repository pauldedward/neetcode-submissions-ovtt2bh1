class Solution {
    public int jump(int[] nums) {
        int currentEnd = 0;
        int maxReach = 0;
        int jumps = 0;
        for(int index = 0; index < nums.length - 1; index++) {
            maxReach = Math.max(maxReach, index + nums[index]);
            if(index == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }
        return jumps;
    }
}
