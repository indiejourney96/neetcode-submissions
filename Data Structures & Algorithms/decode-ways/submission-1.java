class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];

        // -1 means this index has not been calculated yet
        Arrays.fill(cache, -1);

        return dfs(s, 0, cache);
    }

    private int dfs(String s, int i, int[] cache) {

        // Successfully decoded the entire string
        if (i == s.length()) {
            return 1;
        }

        // A number starting with 0 is invalid
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Return the previously calculated result
        if (cache[i] != -1) {
            return cache[i];
        }

        // Case 1: Decode one digit
        int results = dfs(s, i + 1, cache);

        // Case 2: Decode two digits (10 to 26)
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));

            if (num >= 10 && num <= 26) {
                results += dfs(s, i + 2, cache);
            }
        }

        // Store the result for this index
        cache[i] = results;

        return results;
    }
}

// Top-Down DP (Memoization)
// Time Complexity: O(n)
// Space Complexity: O(n)