class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;
        for(int right = 0; right < s.length(); right++) {
            freqArr[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freqArr[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;
            
            int required = windowLength - maxFreq;
            while(required > k) {
                freqArr[s.charAt(left) - 'A']--;
                left++;
                windowLength--;
                required--;
            }
            maxLength = Math.max(maxLength, windowLength);
        }

        return maxLength;
    }
}
