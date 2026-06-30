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
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int noOfLevels = 0;  //level 0,level 1 ,...

        while(!queue.isEmpty()){
            int nodeCountAtLevel = queue.size();  //no of nodes at each level

            //tree ended 
            if(nodeCountAtLevel == 0){
                return noOfLevels;
            }
               //some nodes or one node is there 
            while(nodeCountAtLevel>0){
                TreeNode element = queue.poll();


                //add its children to queue
                if(element.left!=null) queue.add(element.left);
                if(element.right !=null) queue.add(element.right);
                nodeCountAtLevel--; //because we have p0lled an element at the level
            }
            noOfLevels++; //we have completed traversal of one level
        }
     return noOfLevels;
    }
}
