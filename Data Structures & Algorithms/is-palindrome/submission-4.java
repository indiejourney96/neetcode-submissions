class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1; 
        while ( l <= r){
            while (l < r && !validAlphanumeric(s.charAt(l))) {
                l++;
            } while (r > l && !validAlphanumeric(s.charAt(r))){
                r--;
            }  
            if (Character.toLowerCase(s.charAt(l)) !=
           Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++; r--;
        }
        return true;
    }

    
    public boolean validAlphanumeric(char c){
        if ((c >= 'A' && c <= 'Z') ||  (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
            return true;
        } return false;
    } 
}
