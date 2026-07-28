class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();

        for (String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            res.putIfAbsent(sortedStr, new ArrayList<>()); //["act" -> ];
            res.get(sortedStr).add(s); //["act" -> "cat"];
        }
        List<List<String>> ans = new ArrayList<>(res.values());
        return ans;
    }
}
