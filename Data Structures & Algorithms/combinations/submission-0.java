class Solution {
    public List<List<Integer>> combine(int n, int k) {
        /*
        n = 3, k = 2
        1,2,3
        */
        List<Integer> combo = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backTrack(1, k, n, combo, res);
        return res;
    }

    public void backTrack(int current, int k, int n, List<Integer> combo, List<List<Integer>> res) {

        if(combo.size() == k) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if(current > n) {
            return;
        }
        combo.add(current);
        backTrack(current + 1, k, n, combo, res);
        combo.remove(combo.size() - 1);
        backTrack(current + 1, k, n, combo, res);
    }
}