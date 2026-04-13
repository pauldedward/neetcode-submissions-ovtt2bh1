class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
                Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] time : times) {
            adjList.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dfs(k, 0, adjList, dist);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void dfs(int node, int time, Map<Integer, List<int[]>> adjList, Map<Integer, Integer> dist) {
        if(time >= dist.get(node)) {
            return;
        }
        dist.put(node, time);
        if (!adjList.containsKey(node)) return;
        for(int[] edge : adjList.get(node)) {
            dfs(edge[0], time + edge[1], adjList, dist);
        }
    }
    
}
