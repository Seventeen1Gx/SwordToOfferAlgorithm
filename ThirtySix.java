public class ThirtySix {
    // 将二叉搜索树转换成排序的双向链表
    // 要求不能创键新结点，只能调整树中结点指针的指向

    // 思路：修改中序遍历的代码以达到要求
    // 中序遍历能按递增顺序访问到树结点，然后每次遍历到的结点就跟前一个结点作双向互连

    // pre 始终跟踪当前结点的上一个结点
    private TreeNode pre = null;

    // head 记住结果链表的头结点即可
    private TreeNode head = null;

    public TreeNode convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    // 中序遍历，pre 始终是 node 在双向链表中的前一个结点
    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);

        // 访问结点，将这个结点跟 pre 作一个双向互连

        node.left = pre;
        if (pre != null)
            pre.right = node;

        // 改变跟踪，然后进入右子树
        pre = node;

        // 当 head 是 null 时，说明 node 是最小的结点，也就是头结点
        // 下面这句话，整个递归过程中，只会运行一次
        if (head == null)
            head = node;

        inOrder(node.right);
    }


    public static void main(String[] args) {
        // 准备下面这样一棵树来测试

        //          10
        //      6        14
        //    4   8   12    16

        TreeNode ten = new TreeNode(10);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode twelve = new TreeNode(12);
        TreeNode sixteen = new TreeNode(16);

        ten.left = six;
        ten.right = fourteen;

        six.left = four;
        six.right = eight;

        fourteen.left = twelve;
        fourteen.right = sixteen;

        ThirtySix solution = new ThirtySix();
        solution.convert(ten);
    }
}
