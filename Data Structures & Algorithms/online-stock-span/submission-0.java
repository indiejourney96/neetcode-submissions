class StockSpanner {

    List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {

        // Store today's price
        prices.add(price);

        int span = 0;

        // Start from today and scan backwards
        for (int i = prices.size() - 1; i >= 0; i--) {

            if (prices.get(i) <= price) {
                span++;
            } else {
                break;
            }
        }

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */


 // Brute Force 
 // Time complexity: O(n2)
 // Space complexity: O(n)

 // n = number of function calls