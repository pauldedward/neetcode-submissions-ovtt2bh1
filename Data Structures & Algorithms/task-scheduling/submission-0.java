class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqArray = new int[26];
        for(char c : tasks) {
            freqArray[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int f : freqArray) {
            if(f > 0) {
                queue.offer(f);
            }
        }

        int taskCycles = 0;

        while(!queue.isEmpty()) {
            int cycle = n + 1;
            List<Integer> cache = new ArrayList<>();
            while(cycle > 0 && !queue.isEmpty()) {
                int task = queue.poll();
                if(task > 1) {
                    cache.add(task - 1);
                }
                cycle--;
            }
            cache.forEach(queue::offer);
            taskCycles += queue.isEmpty() ? n + 1 - cycle : n + 1;
        }

        return taskCycles;
    }
}
