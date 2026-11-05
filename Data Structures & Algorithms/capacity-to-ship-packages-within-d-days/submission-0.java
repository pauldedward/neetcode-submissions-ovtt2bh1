class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int min = 1;
        for(int weight : weights) {
            min = Math.max(min, weight);
            max += weight;
        }
        while(min < max) {
            int mid = min + (max - min) / 2;
            if(isShippableWithinDays(days, weights, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }



    public boolean isShippableWithinDays(int days, int[] weights, int capacity) {
        int day = 1;
        int totalWeight = 0;
        for(int weight : weights) {
            if(totalWeight + weight > capacity) {
                totalWeight = 0;
                day++;
            }
            totalWeight += weight;
        }
        return day <= days;
    }
}