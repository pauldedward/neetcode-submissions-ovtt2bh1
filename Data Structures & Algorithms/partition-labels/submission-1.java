class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        for(int index = 0; index < s.length(); index++) {
            lastIndexMap.put(s.charAt(index), index);
        }
        List<Integer> result = new ArrayList<>();
        int currentEnd = 0;
        int currentSize = 0;
         for(int index = 0; index < s.length(); index++) {
            currentSize++;
            currentEnd = Math.max(currentEnd, lastIndexMap.get(s.charAt(index)));
        
            if(index == currentEnd) {
                result.add(currentSize);
                currentSize = 0;
            }
        }
        return result;
    }
}
