class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        // Remove previous prices that are less than
        // or equal to today's price.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {

            // Add their accumulated spans
            span += stack.pop()[1];
        }

        // Store today's price and its calculated span
        stack.push(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */


 // Stack 
 // Time complexity: O(n)
 // Space complexity: O(n)

 // n = number of function calls