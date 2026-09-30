class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();

        for (int stone : stones){
            stoneList.add(stone);
        }
        

        while(stoneList.size() > 1){
            Collections.sort(stoneList);
            int stone1 = stoneList.remove(stoneList.size() - 1);
            int stone2 = stoneList.remove(stoneList.size() - 1);
            int cur = stone1 - stone2;
            
            if (cur != 0){
                stoneList.add(cur);
            }
        }
        if (stoneList.isEmpty()){
            return 0;
        }
        return stoneList.get(0);
    }
}

//Brute Force 
//Time complexity: O(n2 log n)
//Space complexity: O(n)
