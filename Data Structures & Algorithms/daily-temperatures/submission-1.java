class Solution {
    public int[] dailyTemperatures(int[] temperatures) { 
        int n = temperatures.length;
        int[] ans = new int[n];

        // Store indices only
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Current temperature is warmer than previous unresolved day
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                // Days waited
                ans[prev] = i - prev;
            }
            // Current day is waiting for a warmer temperature
            stack.push(i);
        }
        return ans;
    }
}
