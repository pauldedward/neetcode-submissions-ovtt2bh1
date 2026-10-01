class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = 0;
        for(int index = 0; index < height.length; index++) {
            max = Math.max(max, height[index]);
            leftMax[index] = max;
        }

        max = 0;
        for(int index = height.length - 1; index >= 0; index--) {
            max = Math.max(max, height[index]);
            rightMax[index] = max;
        }

        int res = 0;

        for(int index = 0; index < height.length; index++) {
            res += Math.min(leftMax[index], rightMax[index]) - height[index];
        }

        return res;
    }
}
