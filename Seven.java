import java.util.HashMap;
import java.util.Map;

public class Seven {
    // 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
    // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

    // 缓存中序遍历数组每个值对应的索引，为了快速拿到
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 缓存操作
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    // 递归构造
    // 因为中序遍历和对应的前序遍历的长度相同，所以这里只传一个 inL 即可
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;

        // 前序遍历数组的第一个值是根结点
        // 然后去中序遍历数组中查找左右子树的划分
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.x);

        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL+1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
