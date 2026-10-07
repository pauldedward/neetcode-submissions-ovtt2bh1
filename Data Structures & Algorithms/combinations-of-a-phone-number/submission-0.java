class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return res;
        }
        backTrack(digits, 0, new StringBuilder());
        return res;
    }

    public void backTrack(String digits, int index, StringBuilder sb) {
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        for(char c : digitToChar[Integer.parseInt(digits.substring(index,index + 1))].toCharArray()) {
            sb.append(c);
            backTrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}
