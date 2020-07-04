public class FiftyFivePointOne {
    // 二叉树的深度

    public int treeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
}
