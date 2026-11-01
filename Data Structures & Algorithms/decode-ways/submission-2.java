class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // dp[i] = number of ways to decode the string from index i onwards
        int[] dp = new int[n + 1];

        // Successfully decoded the entire string
        dp[n] = 1;

        // Calculate the answers from right to left
        for (int i = n - 1; i >= 0; i--) {

            // A number starting with 0 is invalid
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {

                // Case 1: Decode one digit
                dp[i] = dp[i + 1];

                // Case 2: Decode two digits (10 to 26)
                if (i + 1 < n) {
                    int num = Integer.parseInt(s.substring(i, i + 2));

                    if (num >= 10 && num <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }

        return dp[0];
    }
}

// Bottom-Up DP (Tabulation)
// Time Complexity: O(n)
// Space Complexity: O(n)