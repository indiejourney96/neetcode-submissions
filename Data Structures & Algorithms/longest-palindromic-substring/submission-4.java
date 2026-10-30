class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0; int resLen = 0; int n = s.length();

        for (int i = 0 ; i < n; i++){
            int l = i; 
            int r = i;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--; r++;
            }

            int len = r - l - 1;

            if (resLen < len){
                resIdx = l + 1;
                resLen = len;
            }

            l = i; r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--; r++;
            }

            len = r - l - 1;

            if (resLen < len){
                resIdx = l + 1;
                resLen = len;
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
}

// Optimised (Expand Around Center)
// Time Complexity: O(n^2)
// Space Complexity: O(1) auxiliary space
