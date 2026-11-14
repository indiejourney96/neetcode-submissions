class MyHashSet {

    private static class ListNode {
        int key;  
        ListNode next;

        ListNode(int key){
            this.key = key;
        }
    }

    private final ListNode[] set;

    public MyHashSet() {
        set = new ListNode[10000];
        for (int i = 0; i < set.length; i++){
            set[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        ListNode cur = set[key % set.length];
        while (cur.next != null){
            if (cur.next.key == key){
                return;
            }

            cur = cur.next;
        }
        cur.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode cur = set[key % set.length];
        while (cur.next != null){
            if (cur.next.key == key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode cur = set[key % set.length];
        while (cur.next != null){
            if (cur.next.key == key){
                return true;
            }
            
            cur = cur.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

 // Boolean
 // Time Complexity: O(1)
 // Space Complexity: O(1000000)