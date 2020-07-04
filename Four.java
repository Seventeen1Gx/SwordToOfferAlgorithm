public class Four {
    // 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
    // 给定一个数，判断这个数是否在该二维数组中。

    // 思路：由于数组的独特结构，从右上角开始比，每次排除一行或一列

    public boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = matrix.length, col = matrix[0].length;
        // 从右上角开始
        // martrix[r][c] 是待检测的值
        int r = 0, c = col - 1;
        while (r < row && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
}
