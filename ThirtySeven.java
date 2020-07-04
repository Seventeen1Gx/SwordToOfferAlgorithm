public class ThirtySeven {
    // 序列化二叉树

    private String deserializeStr;

    public String serialize(TreeNode root) {
        if (root == null)
            return "#";

        return root.x + " " + serialize(root.left) + " " + serialize(root.right);
    }


    public TreeNode deserialize(String str) {
        deserializeStr = str;
        return deserialize();
    }

    // 序列字符串是把 null 结点一起算进去的前序遍历序列
    // 且每个结点以空格分开

    // 将 deserializeStr 转换成一棵二叉树
    private TreeNode deserialize() {
        if (deserializeStr.length() == 0)
            return null;

        // 找到第一个空格的位置，其之前的那个就代表着根结点
        int index = deserializeStr.indexOf(" ");
        // 代表根结点的串
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        // 剩下的序列
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);

        if (node.equals("#"))
            // 说明代表是一个空结点
            return null;

        // 将 node 转换成根结点
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }
}
