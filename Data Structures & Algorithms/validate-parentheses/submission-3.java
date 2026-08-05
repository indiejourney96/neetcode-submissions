class Solution {
    public boolean isValid(String s) {
        while(s.contains("[]") || s.contains("{}") || s.contains("()")){
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            s = s.replace("()", "");
        }
        return s.isEmpty();
    }
}

//Brute Force
//Time Complexity: O(n2)
//Space Complexity: O(n)