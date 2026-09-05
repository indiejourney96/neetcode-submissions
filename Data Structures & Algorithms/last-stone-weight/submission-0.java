class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();

        for (int stone : stones){
            stoneList.add(stone); //add all stones to list
        }

        //keep smashing stones until 0 or 1 remains
        while (stoneList.size() > 1){
            Collections.sort(stoneList);
            //remove 2 largest stones
            int stone1 = stoneList.remove(stoneList.size() - 1);
            int stone2 = stoneList.remove(stoneList.size() - 1);
            int cur = stone1 - stone2;
            if (cur != 0){ //add diff
                stoneList.add(cur);
            }
        }
        return stoneList.isEmpty() ? 0:  stoneList.get(0);
    }
}

//Brute Force 
//Time complexity: O(n2 log n)
//Space complexity: O(n)
