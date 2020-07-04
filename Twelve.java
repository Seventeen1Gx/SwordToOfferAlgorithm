public class Twelve {
    // 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    // 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。
    // 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。

    // 思路：回溯搜索所有的可能


    // 4 个方向
    private final static int[][] next = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };

    private int rows;
    private int cols;

    // 输入是一维数组，我们要将其转换成二维数组
    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;

        this.rows = rows;
        this.cols = cols;

        // 标记哪些位置被访问了
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);

        // 遍历所有的起始点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 进来之前先检验
    // 检验成功之后，循环往下走

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        // 当前已找到要找的字符串
        if (pathLen == str.length) return true;

        // 不满足要求的情况：
        // 访问点越界 || 已被访问过 || 不是要找的字符
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) return false;

        // 当前访问点满足要求，标记当前位置为被访问，
        // 然后要试验 4 个方向
        marked[r][c] = true;
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;
        }
        // 到这里说明上面的试验都不行
        // 回溯
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
    }
}
