class Solution {
    int[] maxInPath;
    public int rob(int[] nums) {
        maxInPath = new int[nums.length];
        for(int index = 0; index < maxInPath.length; index++) {
            maxInPath[index] = -1;
        }
        return dfs(nums, 0);
    }

    public int dfs(int[] houses, int house) {
        if(house >= houses.length) {
            return 0;
        }

        if(maxInPath[house] != -1) {
            return maxInPath[house];
        }

        maxInPath[house] = Math.max(
            dfs(houses, house + 1),
            houses[house] + dfs(houses, house + 2));

        return maxInPath[house];
    }
}
