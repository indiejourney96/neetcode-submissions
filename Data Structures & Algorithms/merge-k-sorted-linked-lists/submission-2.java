/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
         /*
         * O(n * k) idea:

         */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        // Min-heap: smallest node value stays at the top
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode list : lists){ // Put the first node of every list into the heap
            if (list != null){
                minHeap.offer(list); //Add candidates
            }
        }

        ListNode dummy = new ListNode(0); // Dummy node helps us build the result list
        ListNode cur = dummy;

        // Keep taking the smallest node
        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll(); // Get the smallest node

            cur.next = node;
            cur = cur.next;

            if (node.next != null){ 
                minHeap.offer(node.next);
                // Add the next node from the same list 
                // so it can compete with the other lists
            }
        }
        return dummy.next;
    }
}


 /* Brute force: collect all nodes and sort → O(n log n)
 *
 * Intermediate: scan all k lists for the smallest node each time
 * → O(n * k)
         * Repeatedly scan all k lists to find the smallest node.
         * The heap improves this by finding the smallest node in O(log k).
 *
 * Optimal: min-heap keeps the smallest candidate from each list
 * Time Complexity → O(n log k)
 * Space Complexity -> O(k)

Where 
k is the total number of lists  
n is the total number of nodes across k lists. */
