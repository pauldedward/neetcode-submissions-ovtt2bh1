class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> tempStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int index = 0; index < temperatures.length ; index++) {
            int temp = temperatures[index];
            while(!tempStack.isEmpty() && temperatures[tempStack.peek()] < temp) {
                result[tempStack.peek()] = index - tempStack.pop();
            }
            tempStack.push(index);
        }
        while(!tempStack.isEmpty()) {
            result[tempStack.pop()] = 0;
        }

        return result;
    }
}
