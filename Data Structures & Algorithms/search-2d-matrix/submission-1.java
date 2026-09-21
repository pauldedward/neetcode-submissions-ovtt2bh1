class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0; int right = matrix.length - 1;
        int columns = matrix[0].length;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][columns - 1]) {
                return binarySearch(matrix[mid], target) != -1;
            } else if(target > matrix[mid][columns - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public int binarySearch(int[] array, int target) {
        int left = 0; int right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == target) {
                return mid;
            } else if(array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
