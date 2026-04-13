class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            arr.add(new int[] {entry.getKey(), entry.getValue()});
        }

        arr.sort((a, b) -> b[1] - a[1]);

        int[] results = new int[k];

        for(int index = 0; index < k; index++) {
            results[index] = arr.get(index)[0];
        }

        return results;
    }
}
