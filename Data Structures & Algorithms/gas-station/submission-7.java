class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int totalTank = 0;
        int bestIndex = 0;
        for(int index = 0; index < gas.length; index++) {
            totalTank += gas[index] - cost[index];
            if(totalTank < 0) {
                bestIndex = index + 1;
                totalTank = 0;
            }
        }

        return totalTank >= 0 ? bestIndex : -1;
    }
}
