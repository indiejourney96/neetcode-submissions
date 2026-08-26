class Solution {
    public int countSeniors(String[] details) {
        int count = 0; 
        for (int i = 0; i < details.length; i++){
            int j = 11; 
            if (details[i].charAt(j) >= '6' & details[i].charAt(j+1) >= '0'){
                count++;
            }
        }
        return count;
    }
}