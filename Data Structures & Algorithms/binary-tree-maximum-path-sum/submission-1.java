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

    public int dfs(TreeNode node){
        if (node == null) return 0;

        // Get best downward path from left and right
        // Clamp to 0 — if a subtree is negative, don't include it
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Update global answer: best path with THIS node as the top
        // (can use both left and right branches here)
        res = Math.max(res, node.val + left + right);

        // Return best path going in ONE direction (what we give to our parent)
        // (parent can only use one side — can't take a forked path)
        return node.val + Math.max(left, right);
    }
}

//Optimal Single Pass Solution
//Time Complexity: O(N)  — every node is visited exactly once
//Space: O(H)  — recursion call stack depth
//               O(log N) balanced tree
//               O(N) worst case skewed tree


//I do a single DFS. At each node I get the best downward path sum from the left and right subtrees, clamping negative values to zero so I never include a subtree that hurts the total. I use both sides to update the global answer — that's the best path with the current node as the top. But I only return one side to my parent, because a path handed upward can only go in one direction.
