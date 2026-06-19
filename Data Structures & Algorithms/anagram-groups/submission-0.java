class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>(); //Key, Value : "aet"->["eat","tea","ate"]
        for (String s : strs){
            char[] charArray = s.toCharArray(); //['e','a','t']
            Arrays.sort(charArray); //['a','e','t']
            String sortedStrs = new String(charArray);
            res.putIfAbsent(sortedStrs, new ArrayList<>()); // "aet" : [] 
            res.get(sortedStrs).add(s); //   "aet" : ["eat"]
        }
        return new ArrayList<>(res.values());
    }
}
