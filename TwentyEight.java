public class TwentyEight {
    // 对称二叉树

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;

        // 无需看根结点，只用看左右子树是否对称即可
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;

        if (t1.x != t2.x)
            return false;

        // 两树根结点相同，且子树也要呈对称
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }
}
