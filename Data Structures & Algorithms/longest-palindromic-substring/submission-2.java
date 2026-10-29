
public class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0;  // Starting index of the longest palindrome
        int resLen = 0;  // Length of the longest palindrome
        int n = s.length();

        // Try every character as the center of a palindrome
        for (int i = 0; i < n; i++) {

            // Case 1: Odd-length palindrome (e.g. "aba")
            int l = i;
            int r = i;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            // After the loop, l and r are outside the palindrome
            int len = r - l - 1;

            // Update the longest palindrome found
            if (resLen < len) {
                resIdx = l + 1;
                resLen = len;
            }

            // Case 2: Even-length palindrome (e.g. "abba")
            l = i;
            r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            // Calculate the length of the palindrome
            len = r - l - 1;

            // Update the longest palindrome found
            if (resLen < len) {
                resIdx = l + 1;
                resLen = len;
            }
        }

        // Return the longest palindrome using its starting index and length
        return s.substring(resIdx, resIdx + resLen);
    }
}

// Optimised (Expand Around Center)
// Time Complexity: O(n^2)
// Space Complexity: O(1) auxiliary space


// I optimise the DP solution by removing the 2D table. Instead, I treat each character and each gap between adjacent characters as a possible palindrome center. I expand outward while the characters match, calculate the palindrome length, and update the starting index and length whenever I find a longer palindrome. This keeps the time complexity at \(O(n^2)\) but reduces auxiliary space to \(O(1)\).