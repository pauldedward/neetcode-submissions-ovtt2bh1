class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < s.length()) {
            Character c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            while(freqMap.get(c) > 1) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(right + 1 - left, maxLength);
            right++;
        }
        return maxLength;
    }
}
