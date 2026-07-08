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
class Solution 
{
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if(p == null && q == null){return true;}
        if(p == null && q != null || p != null && q == null){return false;}

        TreeNode pdummy = p;
        TreeNode qdummy = q;

        if(pdummy.val != qdummy.val){return false;}
        boolean answer = isSameTree(pdummy.left , qdummy.left) && isSameTree(pdummy.right , qdummy.right);

        return answer;

    }
}