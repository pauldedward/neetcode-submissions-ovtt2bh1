class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            int diff = target - nums[index];
            if(indexMap.containsKey(diff)) {
                return new int[] {indexMap.get(diff), index};
            }
            indexMap.put(nums[index], index);
        }
        return new int[] {-1,-1};
    }
}
