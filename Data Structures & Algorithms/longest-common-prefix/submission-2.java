class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }

        Arrays.sort(strs);
        int n = Math.min(strs[0].length(),strs[strs.length-1].length());
        for (int i = 0; i < n; i++){
            if (strs[0].charAt(i) != strs[strs.length-1].charAt(i)){
                return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}