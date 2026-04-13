class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int outIndex = 0;
        for(int index = 0; index < nums.length; index++) {
            maxHeap.offer(new int[]{nums[index], index});
            if(index + 1 >= k) {
                while(maxHeap.peek()[1] <= index - k) {
                    maxHeap.poll();
                }
                output[outIndex++] = maxHeap.peek()[0];
            }
        }
        return output;

    }
}
