class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        // Try every possible starting index
        for (int i = 0; i < s.length(); i++) {

            // Stores characters in the current substring
            Set<Character> seen = new HashSet<>();

            // Extend the substring to the right
            for (int j = i; j < s.length(); j++) {

                // Stop once a duplicate character is found
                if (seen.contains(s.charAt(j))) {
                    break;
                }
                // Character is unique so far
                seen.add(s.charAt(j));

                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}


// Brute force (O(n²))
// Start from every index.
// Use a HashSet to detect duplicates.
// Expand until a duplicate appears.

// Optimization
// Notice that when moving from one starting index to the next, much of the work is repeated.
// Instead of rebuilding the HashSet each time, keep a single window and adjust its left boundary when a duplicate is found.
// This naturally leads to the sliding window solution with O(n) time. 
// This transition is easy to explain because the optimized solution reuses the same core idea—maintaining 
// a set of unique characters—but avoids restarting from scratch for every starting position.