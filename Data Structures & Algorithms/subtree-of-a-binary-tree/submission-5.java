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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null){
            return true; //empty tree is considered a subtree
        }

        if (root == null){
            return false; //main tree is empty but subRoot is not, subRoot not found
        }

        if (sameTree(root, subRoot)){
            return true; //check trees starting at the nodes if they are the same
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null){
            return true; // Both trees reached the end at the same time
        }

        // Both nodes exist and have the same value
        if (root != null && subRoot != null && root.val == subRoot.val){
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }

        return false;  // One node is null, or their values are different
    }
}


//Depth First Search (DFS)

//Time Complexity: 0(m * n)
//Space Complexity: O(m + n)

//m = number of nodes in subRoot 
//n = number of nodes in root

