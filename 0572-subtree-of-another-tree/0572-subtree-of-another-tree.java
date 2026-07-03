public class Solution 
{
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        if (root == null) 
        {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) 
    {
        if (t1 == null && t2 == null) 
        {
            return true;
        }
        if (t1 == null || t2 == null) 
        {
            return false;
        }
        return (t1.val == t2.val) && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
