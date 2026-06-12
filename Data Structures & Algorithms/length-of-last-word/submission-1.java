class Solution {
    public int lengthOfLastWord(String s) { 
        int n = s.length();
        int i = n - 1;
        int ans = 0;
        while (s.charAt(i) == ' '){
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' '){
            i--;
            ans++;
        }
        return ans;
    }
}