public class SixEight {
    // 树中两个节点的最低公共祖先

    // 对于 BST
    // 公共祖先 root.val 在 p.val 和 q.val 之间
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.x > p.x && root.x > q.x)
            // 去左子树中找
            return lowestCommonAncestor_1(root.left, p, q);
        if (root.x < p.x && root.x < q.x)
            // 去右子树中找
            return lowestCommonAncestor_1(root.right, p, q);

        return root;
    }

    // 普通二叉树
    // 三种情况，p 是 q 的祖先，或者，q 是 p 的祖先，或者 root 是 p、q 的公共祖先，p、q 分布在左右两侧
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        // 左子树中找 p、q 的公共祖先
        TreeNode left = lowestCommonAncestor_2(root.left, p, q);
        // 右子树中找 p、q 的公共祖先
        TreeNode right = lowestCommonAncestor_2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
