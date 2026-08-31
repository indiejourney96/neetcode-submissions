/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count = 0;  // tracks how many nodes visited so far
    int result = 0; // stores the answer when count reaches k

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        // List is 0-indexed, k is 1-indexed, so subtract 1
        return result;
    }

    public void dfs(TreeNode node, int k){
        if (node == null){
            return ;
        }
        dfs(node.left, k); // visit left subtree first (smaller values)
        count++;                // visited one more node
        if (count == k) {       // this is the kth smallest
            result = node.val;
            return;
        }
        dfs(node.right, k); // visit right subtree last (larger values)
    }
}

//Optimal
//Time:  O(H + k) — H to reach the leftmost node, then k steps
//                  O(log N + k) balanced tree
//                  O(N) worst case for skewed tree
//Space: O(H)     — recursion call stack depth

//Instead of collecting everything into a list, I keep a counter. Every time I visit a node I increment the counter — when it hits k, that's my answer and I stop early.
