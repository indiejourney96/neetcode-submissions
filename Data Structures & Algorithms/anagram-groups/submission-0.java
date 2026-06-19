class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStrs = new String(charArray);
            res.putIfAbsent(sortedStrs, new ArrayList<>());
            res.get(sortedStrs).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
