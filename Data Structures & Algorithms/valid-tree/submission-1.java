class Solution {


    public boolean dfs(int current, int parent, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if(visited.contains(current)) {
            return false;
        }
        visited.add(current);
        for(int neighbour : adjList.getOrDefault(current, new ArrayList<>())) {
            if(neighbour == parent) {
                continue;
            }
            if(!dfs(neighbour, current, adjList, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        if(!dfs(0, -1, adjList, visited)) {
            return false;
        }

        return visited.size() == n;

    }
}
