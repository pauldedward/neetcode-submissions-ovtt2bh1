class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> set = new ArrayList<>();
        dfs(0, s, res, set);
        return res;
    }

    public void dfs(int index, String s, List<List<String>> res, List<String> set) {
        if(index >= s.length()) {
            res.add(new ArrayList<>(set));
            return;
        }
        for(int end = index; end < s.length(); end++) {
            if(isPalindrome(index, end, s)) {
                set.add(s.substring(index, end + 1));
                dfs(end + 1, s, res, set);
                set.remove(set.size() - 1);
            }
        }
        return;
    }

    public boolean isPalindrome(int start, int end, String s) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
