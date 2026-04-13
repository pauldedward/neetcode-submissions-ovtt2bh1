class Solution {
    public int maxArea(int[] heights) {
        int left = 0; int right = heights.length - 1;
        int max = 0;
        while(left < right) {
            int area = Math.min(heights[right], heights[left]) * (right - left);
            max = Math.max(max, area);
            if(heights[left] > heights[right]) {
                right--;
            } else if(heights[right] > heights[left]) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}
