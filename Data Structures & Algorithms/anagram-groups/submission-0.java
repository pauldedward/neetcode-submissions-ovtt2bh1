class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for(String str : strs) {
            int[] key = new int[26];
            for(char c : str.toCharArray()) {
                key[c - 'a']++;
            }
            result
            .computeIfAbsent(Arrays.toString(key),k -> new ArrayList<>())
            .add(str);
        }
        return new ArrayList<>(result.values());
    }
}
