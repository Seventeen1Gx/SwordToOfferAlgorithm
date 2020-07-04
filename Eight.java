public class Eight {
    // 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。
    // 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

    // 思路：如果该结点的右子树不为空，则该结点的下一个结点就是右子树的最左结点。
    // 如果该结点的右子树为空，则要向上找。
    // 又分下列两种情况。
    // 如果该结点是父节点的左儿子，那其下一个结点就是它的父节点。
    // 如果该结点是父节点的右儿子，则看其父节点是不是其爷爷结点的左儿子，是的话就是爷爷结点，否则还要看爷爷结点是不是其太爷爷的左还是右儿子。
    //
    // 也就是一直往祖先找，找到第一个是左儿子结点的那个结点的父亲就是下一个结点。
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode p = pNode.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            while (pNode.next != null) {
                // 父结点
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                // 没找到就往上
                pNode = pNode.next;
            }
        }
        return null;
    }
}
