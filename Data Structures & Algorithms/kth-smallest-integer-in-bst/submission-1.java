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
//https://imagedelivery.net/CLfkmk9Wzy8_9HRyug4EVA/dca6c42d-2327-4036-f7f2-3e99d8203100/public$0
class Solution {
    public int kthSmallest(TreeNode root, int k) {
         
         List<Integer> list = new ArrayList<>();
          inOrder(root,list);
          return list.get(k-1);
    }

    public void inOrder(TreeNode node, List<Integer> list){
            if(node == null) return;

            inOrder(node.left,list);
            list.add(node.val);
            inOrder(node.right,list);
    }
}
