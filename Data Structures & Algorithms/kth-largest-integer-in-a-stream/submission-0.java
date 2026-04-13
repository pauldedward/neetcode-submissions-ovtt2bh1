class KthLargest {

    PriorityQueue<Integer> minHeap;
    int kSize;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        kSize = k;
        for(int num : nums) {
            minHeap.add(num);
        }
        while(minHeap.size() > kSize) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size() > kSize) {
            minHeap.poll();
        }       
        return minHeap.peek();
    }
}
