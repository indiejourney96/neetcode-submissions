class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        // Try every possible center
        for (int i = 0; i < n; i++) {

            // Case 1: Odd-length palindrome (e.g. "aba")
            int l = i;
            int r = i;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }

            // Case 2: Even-length palindrome (e.g. "abba")
            l = i;
            r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}

// Optimised (Expand Around Center)
// Time Complexity: O(n^2)
// Space Complexity: O(1)