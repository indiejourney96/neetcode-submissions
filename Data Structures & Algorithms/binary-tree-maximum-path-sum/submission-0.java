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
    int res = Integer.MIN_VALUE; //global ans

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    // Returns the best path sum going DOWNWARD from this node
    // (only one direction — left OR right — not both)
    // Returns 0 if the best option is to not extend the path at all (negative subtree)

    public int getMax(TreeNode node){
        if (node == null) return 0;

        int left = getMax(node.left);
        int right = getMax(node.right);

        // Best path going down: this node + the better of left or right
        int path = node.val + Math.max(left, right);

        // If path is negative, don't extend — return 0 (skip this subtree)
        return Math.max(0, path);
    }

   // Visits every node and checks: what is the best path with THIS node as the top?
    public void dfs(TreeNode node){
        if (node == null) return;

        // Best downward path from left child and right child
        int left = getMax(node.left);
        int right = getMax(node.right);

        // Path through this node as the top = left branch + this node + right branch
        res = Math.max(res, node.val + left + right);

        // Check every other node as a potential top of the best path
        dfs(node.left);
        dfs(node.right);
    }
}

//Brute Force 
//Time Complexity: O(n2) — dfs visits every node, and for each node, getMax traverses its entire subtree
//Space Complexity: O(n)

