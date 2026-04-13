class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] exists = new boolean[3];
        for(int index = 0; index < triplets.length; index++) {
            int[] triplet = triplets[index];
            if(triplet[0] <= target[0] 
                && triplet[1] <= target[1] 
                && triplet[2] <= target[2]) {
                    if(triplet[0] == target[0]) {
                        exists[0] = true;
                    }
                    if(triplet[1] == target[1]) {
                        exists[1] = true;
                    }
                    if(triplet[2] == target[2]) {
                        exists[2] = true;
                    }
                }
        }
    return exists[0] && exists[1] && exists[2];
    }
}
