class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0; 
        int maxFreq = 0; 
        int left = 0;
        
        Map<Character,Integer> count = new HashMap<>();

        // Expand the window
        for (int right = 0; right < s.length(); right++){

                char c = s.charAt(right);

                if (count.containsKey(c)){ // Increase frequency of current character
                    count.put(c, count.get(c) + 1);
                } else {
                    count.put(c, 1);
                }

            maxFreq = Math.max(maxFreq, count.get(c)); // Update highest frequency
            
            //Too many replacements needed
            while ((right - left + 1) - maxFreq > k){
                char leftChar = s.charAt(left);

                count.put(leftChar, count.get(leftChar) - 1);

                left++;
            }

            // Current window is valid 
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

// Time Complexity: O(n) 
// Space Complexity: O(26) -> O(1) 


// We can optimize this because consecutive substrings overlap.
// Instead of rebuilding the frequency map each time, 
// left'll use a sliding window. left'll keep one frequency map, 
// expand the right pointer, and only move the left pointer when the window requires more than k replacements.
// That reduces the time complexity to O(n)."