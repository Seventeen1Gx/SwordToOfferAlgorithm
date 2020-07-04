public class FiftyFour {
    // 二叉查找树的第 K 的结点

    private TreeNode ret;
    private int cnt = 0;

    // 利用中序遍历 BST 有序的特点
    public TreeNode KthNode(TreeNode root, int k) {
        inOrder(root, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        // 递归出口和剪枝
        if (root == null || cnt >= k)
            return;

        inOrder(root.left, k);

        cnt++;
        if (cnt == k)
            ret = root;

        inOrder(root.right, k);
    }
}
