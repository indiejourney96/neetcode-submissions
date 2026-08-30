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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxVal){
        if (root == null){
            return 0;
        }

        // This node is "good" if no value on the path from root was greater
        int res = (root.val >= maxVal) ? 1 : 0;
        
        maxVal = Math.max(root.val, maxVal);
        res += dfs(root.left, maxVal);
        res += dfs(root.right, maxVal);
        
        return res;
    }
}

//DFS
//Time Complextiy: O(n)
//Space Complexity: O(n)

//I do a DFS and carry the maximum value seen so far on the current path. At each node, if the node's value is greater than or equal to that maximum, it's a good node. Then I update the max and recurse into both children. Because the max is passed by value, each path tracks its own independent maximum. I return the total count of good nodes
