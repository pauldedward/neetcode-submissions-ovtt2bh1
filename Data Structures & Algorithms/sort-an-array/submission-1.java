class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // public void quickSort(int[] arr, int low, int high) {
    //     if(low < high) {
    //         int pivot = partition(arr, low, high);
    //         quickSort(arr, low, pivot - 1);
    //         quickSort(arr, pivot + 1, high);
    //     }
    // }

    // public void swap(int[] arr, int left, int right) {
    //     int temp = arr[left];
    //     arr[left] = arr[right];
    //     arr[right] = temp;
    // }

    // public int partition(int[] arr, int low, int high) {
    //     int pivot = arr[high];
    //     int left = low - 1;
        
    //     for(int right = low; right < high; right++) {
    //         if(arr[right] <= pivot) {
    //             left++;
    //             swap(arr, left, right);
    //         }
    //     }
    //     swap(arr, left + 1, high);
    //     return left + 1;
    // }

    public void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        List<Integer> tempArray = new ArrayList<>();
        int lowIndex = low;
        int highIndex = mid + 1;

        while(lowIndex <= mid && highIndex <= high) {
            if(arr[lowIndex] <= arr[highIndex]) {
                tempArray.add(arr[lowIndex]);
                lowIndex++;
            } else {
                tempArray.add(arr[highIndex]);
                highIndex++;
            }
        }

        while(lowIndex <= mid) {
            tempArray.add(arr[lowIndex]);
            lowIndex++;
        }

        while(highIndex <= high) {
            tempArray.add(arr[highIndex]);
            highIndex++;
        }

        for(int index = low; index <= high; index++) {
            arr[index] = tempArray.get(index - low);
        }
    }
}