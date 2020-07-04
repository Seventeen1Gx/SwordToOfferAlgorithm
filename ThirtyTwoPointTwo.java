import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ThirtyTwoPointTwo {
    // 把二叉树打印成多行

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(pRoot);
        while (!queue.isEmpty()) {
            // 每次访问一层
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();

            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.x);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }
}
