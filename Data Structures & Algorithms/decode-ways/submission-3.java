class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // Base cases:
        // dp[n] = 1 (successfully decoded the entire string)
        // dp[n + 1] = 0 (outside the string)
        int dp1 = 1;
        int dp2 = 0;

        // Calculate from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = 0;

            // A number starting with 0 is invalid
            if (s.charAt(i) != '0') {

                // Case 1: Decode one digit
                current = dp1;

                // Case 2: Decode two digits (10 to 26)
                if (i + 1 < n) {
                    int num = Integer.parseInt(s.substring(i, i + 2));

                    if (num >= 10 && num <= 26) {
                        current += dp2;
                    }
                }
            }

            // Move the DP values one step backwards
            dp2 = dp1;
            dp1 = current;
        }

        return dp1;
    }
}

// Space Optimised DP
// Time Complexity: O(n)
// Space Complexity: O(1)