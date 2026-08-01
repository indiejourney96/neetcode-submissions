class Solution {
    public boolean isPalindrome(String s) {
        int l = 0; int r = s.length() - 1;
        while (l < r){
            // Skip all consecutive non-alphanumeric characters.
            // Use while (not if) because there may be multiple invalid characters in a row.
            while (l < r && !validAlpha(s.charAt(l))){
                l++;
            }
            while (r > l && !validAlpha(s.charAt(r))){
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++; r--; //if l = r, move the both pointers
        }    
        return true;
    }

    public boolean validAlpha(char c){
         if ((c >= 'A' && c <= 'Z') ||  (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
            return true;
        }
    return false;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
