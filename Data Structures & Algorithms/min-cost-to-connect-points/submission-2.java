class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                adjList.computeIfAbsent(i, i1 -> new ArrayList<>()).add(new int[] {dist, j});
                adjList.computeIfAbsent(j, j1 -> new ArrayList<>()).add(new int[] {dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int res = 0;
        pq.offer(new int[] {0, 0});
        while(visited.size() < N) {
            int[] point = pq.poll();
            if(!visited.contains(point[1])) {
                visited.add(point[1]);
                res += point[0];
                for(int[] neighbour : adjList.getOrDefault(point[1], new ArrayList<>())) {
                    pq.offer(neighbour);
                }
            }
        }

        return res;
    }
}
