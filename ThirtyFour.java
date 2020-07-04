import java.util.ArrayList;

public class ThirtyFour {
    // 二叉树中和为某一值的路径

    // 回溯，每次试验向左和向右两种走法


    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    // node 当前走到的结点
    // target 还剩下的目标值
    // path 已走过的路径
    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;

        // 统计走过当前这个结点
        path.add(node.x);
        target -= node.x;
        if (target == 0 && node.left == null && node.right == null) {
            // 走到叶子结点时，刚好是目标值
            ret.add(path);
        } else {
            // 不满足要求，还要往下走
            // 向左
            backtracking(node.left, target, path);
            // 向右
            backtracking(node.right, target, path);
        }
        // 已经考虑了向左向右的情况，回到这里
        // 要将最后一个元素去掉
        // 也就是回溯
        path.remove(path.size() - 1);

        // 回到父节点中
    }
}
