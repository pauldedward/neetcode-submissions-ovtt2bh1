class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]));
        for(int[] point : points) {
            pq.offer(point);
            while(pq.size() > k) {
                pq.poll();
            }
        }
        int index = k - 1;
        int[][] res = new int[k][2];
        while(!pq.isEmpty()) {
            res[index] = pq.poll();
            index--;
        }

        return res;
    }
}
