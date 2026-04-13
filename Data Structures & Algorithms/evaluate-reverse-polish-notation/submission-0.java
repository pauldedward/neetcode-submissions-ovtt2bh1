class Solution {
    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        String operators = "+-/*";
        for(String s : tokens) {
            if(operators.contains(s)) {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+": stack.push(String.valueOf(a + b)); break;
                    case "-": stack.push(String.valueOf(b - a)); break;
                    case "*": stack.push(String.valueOf(a * b)); break;
                    case "/": stack.push(String.valueOf(b / a)); break;
                }
            } else {
                stack.push(s);
            }
        }
        return stack.isEmpty() ? 0 : Integer.parseInt(stack.peek());
    }
}
