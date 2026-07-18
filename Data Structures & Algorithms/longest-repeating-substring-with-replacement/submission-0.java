class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0; 

        //Try every possible starting position 
        for (int i = 0; i < s.length(); i++){

            Map<Character, Integer> count = new HashMap<>(); // Count frequency of each character in current substring
            int maxFreq = 0;  // Highest frequency character in current substring

            for (int j = i; j < s.length() ; j++){ // Extend the substring to the right
                char c = s.charAt(j);

                if (count.containsKey(c)){ // Increase frequency of current character
                    count.put(c, count.get(c) + 1);
                } else {
                    count.put(c, 1);
                }

            maxFreq = Math.max(maxFreq, count.get(c)); // Update highest frequency
            
            int windowsLength = j - i + 1; 
            int replacementNeeded = windowsLength - maxFreq; // Characters to replace = Window length - most frequent character

            if (replacementNeeded <= k){ // Valid substring
                maxLength = Math.max(maxLength, windowsLength);
                }
            }
        }
        return maxLength;
    }
}

// Time Complexity: O(n^2) 
// Space Complexity: O(26) -> O(1) 


// I'll first solve it using brute force. 
// For every starting position, I extend the substring one character at a time. 
// I keep a frequency map of the characters and track the highest frequency in the current substring. 
// The minimum replacements needed is the window length minus the highest frequency. 
// If that value is less than or equal to k, the substring is valid,
// so I update the answer. This solution works but has O(n²) time complexity because I restart from every index.


// We can optimize this because consecutive substrings overlap.
// Instead of rebuilding the frequency map each time, 
// I'll use a sliding window. I'll keep one frequency map, 
// expand the right pointer, and only move the left pointer when the window requires more than k replacements.
// That reduces the time complexity to O(n)."