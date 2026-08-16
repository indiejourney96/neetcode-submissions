class LRUCache {
    private ArrayList<int[]> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new ArrayList<>();
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] tmp = cache.remove(i); //remove previous position
                cache.add(tmp); //add to current position
                return tmp[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for (int i = 0; i < cache.size(); i++){
            if (cache.get(i)[0] == key){
                int[] tmp = cache.remove(i);
                tmp[1] = value;
                cache.add(tmp);
                return;
            }
        }

        if (capacity == cache.size()){
            cache.remove(0);
        }
        cache.add(new int[]{key,value});
    }
}


//Brute Force
//Time complexity: O(n)
//Space complexity: O(n)

//My straightforward solution is to maintain the cache in an ArrayList ordered from least recently used to most recently used. Whenever an item is accessed or updated, I remove it from its current position and add it to the end. If the cache is full, I remove the first item."


//The downside is that finding a key requires scanning the ArrayList, so get and put are O(n). I can optimize this using a HashMap for O(1) key lookup and a doubly linked list for O(1) insertion and removal.
