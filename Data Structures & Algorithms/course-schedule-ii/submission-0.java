class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] preReq : prerequisites) {
            adjList.computeIfAbsent(preReq[1], k -> new ArrayList<>()).add(preReq[0]);
            indegree[preReq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int course = 0; course < numCourses; course++) {
            if(indegree[course] == 0) {
                queue.offer(course);
            }
        }
        int[] output = new int[numCourses];
        int outIndex = 0;
        int finished = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            output[outIndex++] = course;
            finished++;
            for(int neigh : adjList.getOrDefault(course, Collections.emptyList())) {
                --indegree[neigh];
                if(indegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }
        return finished == numCourses ? output : new int[0];
    }
}
