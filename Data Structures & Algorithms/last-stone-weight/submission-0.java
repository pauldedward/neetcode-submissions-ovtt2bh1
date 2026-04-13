class Solution {
    public int lastStoneWeight(int[] stones) {
                PriorityQueue<Integer> stoneQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int s : stones) {
            stoneQueue.add(s);
        }

        while(stoneQueue.size() > 1) {
            int heaviest = stoneQueue.poll();
            int secondHeaviest = stoneQueue.poll();
            if(heaviest != secondHeaviest) {
                stoneQueue.add(heaviest - secondHeaviest);
            }
        }

        return stoneQueue.isEmpty() ? 0 : stoneQueue.poll();
    }
}
