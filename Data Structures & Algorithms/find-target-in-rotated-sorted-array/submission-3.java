class Solution {
    public int search(int[] nums, int target) {
        /*
        3,4,5,6,1,2 target 1


        */

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        int pivot = left;
        int result = binarySearch(nums, 0, pivot, target);
        if(result != -1) {
            return result;
        }
        return binarySearch(nums, pivot, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
