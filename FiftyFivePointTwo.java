public class FiftyFivePointTwo {
    // 平衡二叉树

    // 在求树高的过程中，判断有没有违规
    // 即检测每个结点的左右子树高度之差有没有超过 1

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}
