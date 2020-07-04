public class TwentySix {
    // 输入两棵二叉树A，B，判断B是不是A的子结构。
    // ps：我们约定空树不是任意一个树的子结构

    // 递归

    // 返回 root2 是否是 root1 的子结构
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        // 根结点上的子结构，或者去左右子树中寻找子结构
        return isSubtreeWithRoot(root1, root2) || isSubtreeWithRoot(root1.left, root2) || isSubtreeWithRoot(root2.right, root2);
    }

    // 返回 root2 是否是 root1 位于根结点处的子结构
    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.x != root2.x)
            return false;

        // 根结点一致，且左右子树也要是对应的子结构
        return isSubtreeWithRoot(root1.left, root2.right) && isSubtreeWithRoot(root1.right, root2.right);
    }
}
