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



// //*      10
//          /
//         5
//        / \
//       4   6


class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{root.val};
        dfs(root,res);  //even though i pass root, it starts from bottommost node and checks if it has children
        //And from there the max path gets updated and we move forward towards the root.
        return res[0];
    }
    public int dfs(TreeNode root,int[] res){
        if(root==null){
            return 0;
        }

        int leftMax = Math.max(dfs(root.left,res),0); //to avoid negative nodes
        int rightMax = Math.max(dfs(root.right,res),0); //to avoid negatives 


        //do as if u calculate full path
        // 5 (root.val)
//        / \
//   lm  4   6 rm
        res[0] = Math.max(res[0],root.val+leftMax+rightMax); //15 but its not possible as 10 is parent of 5 so complete path is not posswible
        //now we know we cant take complete path so choose the max path from left or right
        return root.val + Math.max(leftMax,rightMax); //initially 11

    }
}
