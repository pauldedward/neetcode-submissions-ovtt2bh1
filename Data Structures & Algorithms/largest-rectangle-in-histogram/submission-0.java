class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftMost = new int[heights.length];
        int[] rightMost = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for(int index = 0; index < heights.length; index++) {
            leftMost[index] = -1;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[index]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                leftMost[index] = stack.peek();
            }
            stack.push(index);
        }

        stack.clear();
        
        for(int index = heights.length - 1; index >= 0; index--) {
            rightMost[index] = heights.length;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[index]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                rightMost[index] = stack.peek();
            }
            stack.push(index);
        }
        
        int maxArea = 0;

        for(int index = 0; index < heights.length; index++) {
            maxArea = Math.max(maxArea, heights[index] * (rightMost[index] - 1 - leftMost[index]));
        }

        return maxArea;
    }
}
