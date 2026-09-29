class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int left = low - 1;
        
        for(int right = low; right < high; right++) {
            if(arr[right] <= pivot) {
                left++;
                swap(arr, left, right);
            }
        }
        swap(arr, left + 1, high);
        return left + 1;
    }
}