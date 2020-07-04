public class ThirtyThree {
    // 二叉搜索树的后序遍历序列

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    // 递归验证
    private boolean verify(int[] sequence, int first, int last) {
        // 一棵树的后序遍历序列分为三部分
        // 左子树的后序遍历序列+右子树的后序遍历序列+根结点

        if (last - first <= 1)
            return true;

        int rootVal = sequence[last];

        // 寻找左右子树的后序遍历序列分界线，根据 BST 的特性
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= rootVal)
            cutIndex++;

        // 发现右子树的后序遍历序列中有小于根结点的，则错误
        for (int i = cutIndex; i < last; i++) {
            if (sequence[i] < rootVal)
                return false;
        }

        // 右子树中的元素大小都大于根结点
        // 再递归检查左右子树
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last);
    }
}
