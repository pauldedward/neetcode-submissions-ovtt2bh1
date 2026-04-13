class Solution {
public int minEatingSpeed(int[] piles, int h) {
        int min = 1; int max = 1;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }

        int feasible=max;
        while(min<=max) {
            int mid = min + (max - min) / 2;
            if(canEatWithThisRate(piles, h, mid)) {
                feasible = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return feasible;
    }

    public boolean canEatWithThisRate(int[] piles, int hours, int rateOfEating) {
        int hoursTaken = 0;
        for(int p : piles) {
            hoursTaken += (p + rateOfEating - 1) / rateOfEating;
        }
        return hours >= hoursTaken;
    }
}
