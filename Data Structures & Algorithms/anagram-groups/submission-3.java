class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        //Key, Value : "[1, 0, 0, 0, 1, 0, 0, 0, 0, ..., 1, 0]"->["eat","tea","ate"]
        
        for (String s : strs){
            int[] count = new int[26];
            char[] charArray = s.toCharArray(); //['e','a','t']
            for (char c : charArray){
                count[c - 'a']++;
            }
            String str = Arrays.toString(count);
            res.putIfAbsent(str, new ArrayList<>()); 
            // "[1, 0, 0, 0, 1, 0, 0, 0, 0, ..., 1, 0]" : [] 
            res.get(str).add(s); 
            //"[1, 0, 0, 0, 1, 0, 0, 0, 0, ..., 1, 0]" : ["str"] 
        }

        List<List<String>> ans = new ArrayList<>(res.values());
        return ans;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)