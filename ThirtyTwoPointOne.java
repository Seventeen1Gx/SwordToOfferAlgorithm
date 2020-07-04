import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ThirtyTwoPointOne {
    // 从上往下打印二叉树

    // 使用队列来进行层次遍历
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();

        // 先把根结点入队
        queue.add(root);
        // 当队列不为空时循环
        while (!queue.isEmpty()) {
            // 每次访问一层
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.x);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }
}
