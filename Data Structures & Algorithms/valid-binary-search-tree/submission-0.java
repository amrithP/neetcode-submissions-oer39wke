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

        List<Integer> list = new ArrayList<>();

        inOrderTrav(root,list); //populate the list with inorder traversal

        for(int i=0;i<list.size()-1;i++){
            //check if sorted ascending
           // = is for finding out duplicate case
            if(list.get(i+1)<=list.get(i)){
                return false;
            }
        }
        return true;
    }

    public void inOrderTrav(TreeNode node , List<Integer> list){
        if(node==null) return;

        inOrderTrav(node.left,list);
        list.add(node.val);
        inOrderTrav(node.right,list);
    }
}
