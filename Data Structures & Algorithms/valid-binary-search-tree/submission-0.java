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
    public boolean isValidBST(TreeNode root) {
        // Start with no constraints — root can be any value
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, int min, int max){
        if (root == null){
            return true;
        }
        // This node must be strictly inside the allowed (min, max) range
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Left child must be less than current node (new max = node.val)
        // Right child must be greater than current node (new min = node.val)
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}

//DFS
//Time Complexity: O(n)
//Space Complexity: O(n)

//I do a DFS and pass a valid range down to each node. The root can be anything, so it starts with no constraints. When I go left, the current node becomes the new upper bound. When I go right, it becomes the new lower bound. If any node falls outside its allowed range, the tree is invalid. I use Long boundaries instead of Integer to avoid edge cases where a node's value equals Integer.MIN or MAX.
