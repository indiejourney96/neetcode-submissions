class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        // Dummy node points to the beginning of the list
        // and makes reconnecting groups easier
        ListNode dummy = new ListNode(0, head);

        // Node immediately before the current group
        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node in the current group
            ListNode kth = getKth(groupPrev, k);

            // Not enough nodes left → leave them unchanged
            if (kth == null) {
                break;
            }

            // Save the first node AFTER the group
            ListNode groupNext = kth.next;

            // Reverse the group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                // Save next node before changing the pointer
                ListNode tmp = curr.next;

                // Reverse the pointer
                curr.next = prev;

                // Move forward
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    // Find the kth node starting from groupPrev
    private ListNode getKth(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}