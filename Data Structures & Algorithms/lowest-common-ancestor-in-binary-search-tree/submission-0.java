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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ptr = root;

        while(ptr!=null){
            if(p.val > ptr.val && q.val > ptr.val){
                ptr = ptr.right;
            }
            else if(p.val <ptr.val && q.val<ptr.val){
                ptr = ptr.left;
            }
            else{
                return  ptr;
            }
        }
        return null;
    }
}
