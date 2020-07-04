public class TwentySeven {
    // 操作给定的二叉树，将其变换为源二叉树的镜像。

    public void mirro(TreeNode root) {
        if (root == null)
            return;

        // 交换左右子树的位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归处理左右子树
        mirro(root.left);
        mirro(root.right);
    }
}
