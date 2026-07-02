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

        String full = preOrderTraversal(root);
        String sub =  preOrderTraversal(subRoot);

        return (full.contains(sub));

    }

    String preOrderTraversal(TreeNode node){
        if(node==null){
            return "null";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(node.val); //root
        builder.append(preOrderTraversal(node.left));
        builder.append(preOrderTraversal(node.right));

        return builder.toString();
    }
}
