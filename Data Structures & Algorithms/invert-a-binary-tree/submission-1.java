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
    public TreeNode invertTree(TreeNode root) {
        // Base case: nothing to invert
        if (root == null) return null;

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left subtree
        invertTree(root.left);
        // Recursively invert the right subtree
        invertTree(root.right);

        return root;
    }
}


//Depth-search first 
//Time Complexity : O(n)
//Space Complexity : O(n)

/*
Interview explanation:
"I use DFS recursion to invert the tree.

For each node, I first swap its left and right children.
Then I recursively do the same thing for the left and right subtrees.

The base case is when the node is null, because there is nothing to invert.

Since I visit every node once, the time complexity is O(n).
The recursive call stack uses O(h) space, where h is the height of
the tree. In the worst case, the tree can be completely unbalanced,
so the space complexity becomes O(n)."

*/