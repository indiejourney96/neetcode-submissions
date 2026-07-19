class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        int[] s1Count = new int[26]; // Character counts for s1
        int[] s2Count = new int[26]; // Character counts for current s2 window

        for (char c : s1.toCharArray()){ 
            s1Count[c - 'a']++; // Count characters in s1
        }

        // Build the first window
        for (int i = 0; i < s1.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) {
            return true; // Check the first window
        }        

        // First window is already built and checked, so start sliding from the next character
        for (int i = s1.length(); i < s2.length() ; i++){
            
            s2Count[s2.charAt(i - s1.length()) - 'a']--; // Remove left character

            s2Count[s2.charAt(i) - 'a']++; // Add right character

            if (Arrays.equals(s1Count, s2Count)){
                return true;
            }
        }

        return false;
    }
}

// The brute-force solution is already improved because we only consider
// substrings with the same length as s1. However, we're still sorting 
// every substring independently, even though adjacent substrings overlap 
// by almost all of their characters.


// Instead of rebuilding and sorting each window, I can maintain a frequency count 
// of the current window. As the window slides, one character leaves and one enters, 
// so I simply decrement one count and increment another. 
// Comparing two frequency arrays takes constant time because the alphabet size 
// is fixed at 26 lowercase letters. 
// This reduces the overall time complexity from O((n−m+1)⋅mlogm) to O(n).