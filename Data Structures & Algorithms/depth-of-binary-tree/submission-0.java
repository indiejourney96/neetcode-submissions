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
    public int maxDepth(TreeNode root) {
        if (root == null){ // Empty tree has depth 0
            return 0;
        }
        int left = maxDepth(root.left); // Find the depth of the left subtree
        int right = maxDepth(root.right); // Find the depth of the right subtree

        int count = 1 + Math.max(left, right); //count = 1 + (2,1)

        return count;
    }
}

//Depth First Search
//Time Complexity: O(n)
//Space Complexity: O(h) 
//n = number of node, h = height of trees

/*Interview explanation:

"I use DFS recursion to find the maximum depth.

For each node, I recursively find the depth of its left and right
subtrees. I then take the larger depth and add 1 for the current node.

The base case is a null node, which has depth 0.

Every node is visited once, so the time complexity is O(n).
The recursion stack uses O(h) space, where h is the height of the tree.
In the worst case, the tree is completely unbalanced, so it is O(n)."
*/
