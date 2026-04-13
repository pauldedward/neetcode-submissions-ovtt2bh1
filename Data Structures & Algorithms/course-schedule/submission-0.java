class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int index = 0; index < numCourses; index++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] pReq : prerequisites) {
            adjList.get(pReq[1]).add(pReq[0]);
        }

        int[] state = new int[numCourses];

        for(int index = 0; index < numCourses; index++) {
            if(state[index] != 2 && hasCycle(index, adjList, state)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(int course, List<List<Integer>> adjList, int[] state) {
        state[course] = 1;
        for(int neigh : adjList.get(course)) {
            if(state[neigh] == 1) {
                return true;
            }
            if(hasCycle(neigh, adjList, state)) {
                return true;
            }
        }
        state[course] = 2;
        return false;
    }
}
