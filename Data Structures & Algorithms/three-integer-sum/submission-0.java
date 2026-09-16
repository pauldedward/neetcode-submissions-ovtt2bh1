class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        
        for(int index = 0; index < nums.length - 1; index++) {
            if(nums[index] > 0) {
                return res;
            }
            if(index > 0 && nums[index - 1] == nums[index]) {
                continue;
            }
            int left = index + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(new ArrayList<>(List.of(nums[index] , nums[left] , nums[right])));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
