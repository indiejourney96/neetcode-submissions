class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Sorted = s1.toCharArray();
        Arrays.sort(s1Sorted);
        
        String s1SortedStr = new String (s1Sorted);

        // Try every substring with the same length as s1
        for (int i = 0 ; i <= s2.length() - s1.length(); i++){
            String s2Sub = s2.substring(i , i + s1.length());

            char[] s2SubArray = s2Sub.toCharArray();
            Arrays.sort(s2SubArray);

            String s2SortedSubStr = new String (s2SubArray);
            if (s2SortedSubStr.equals(s1SortedStr)){
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