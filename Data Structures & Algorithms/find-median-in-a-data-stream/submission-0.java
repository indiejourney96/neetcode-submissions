class MedianFinder {
    private ArrayList<Integer> data;

    public MedianFinder() {
        data = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        data.add(num);
    }
    
    public double findMedian() {
        Collections.sort(data);
        int n = data.size();
        if ((n % 2) == 1){ //odd number
            return data.get(n / 2);
        } else { //even number
            return (data.get(n / 2) + data.get(n / 2 - 1)) / 2.0;
        }
    }
}

//Sorting 
// addNum(num):     O(1)
// findMedian():    O(N log N)  — sorts every time
// Space:           O(N)
