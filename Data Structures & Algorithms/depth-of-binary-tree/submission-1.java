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
        Queue<TreeNode> queue = new LinkedList<>(); //Store nodes level by level

        if (root != null){
            queue.add(root); //start with root
        }
        
        int level = 0; 
        while (!queue.isEmpty()){ //Process tree one level at a time
            int size = queue.size(); //No of nodes at current level
            
            for (int i = 0; i < size; i++){ //Process every node in this level
                TreeNode node = queue.poll();
                if (node.left != null){ //add left child to next level
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            level++; //finished one level
        }
        return level;
    }
}

//Breath-first search 
//Time complexity: O(n)
//Space complexity: O(n)

//I'll use BFS because BFS naturally processes the tree level by level. I put the root into a queue, then for each level I process all nodes currently in the queue and add their children. After processing one complete level, I increment the depth. When the queue becomes empty, the depth is the maximum depth of the tree.