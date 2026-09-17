class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();

        String openBracks = "({[";
        String closingBracks = ")}]";

        for(Character c : s.toCharArray()) {
            if(openBracks.contains("" +c)) {
                stack.push(c);
            } else if(closingBracks.contains("" +c)) {
                if(stack.isEmpty()) {
                    return false;
                }
                if(openBracks.indexOf(stack.peek()) != closingBracks.indexOf(c)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
