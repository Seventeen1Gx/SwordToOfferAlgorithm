public class Thirteen {
    // 地上有一个 m 行和 n 列的方格。
    // 一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
    //
    // 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。
    // 请问该机器人能够达到多少个格子？

    // 深度优先搜索，利用回溯试错
    // 问的是能够到达的格子数，而不是最远走多少格!

    private static final int[][] next = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    // 记录对应格子的数位之和
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        // 先算好每个位置的数位之和
        initDigitSum();

        // 访问标记
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    public void dfs(boolean[][] marked, int r, int c) {
        // 现在走到[r,c]，开始测试这一步能不能走

        // 当前位置不满足要求：越界 || 已被访问过 || 数位之和超过阈值
        if (r < 0 || r >= rows || c < 0 || c>= cols || marked[r][c] || this.digitSum[r][c] > threshold)
            return;

        // 当前位置满足要求，计数加 1
        // 标记被访问，并在左右上下试验
        marked[r][c] = true;
        cnt++;
        for (int[] n : next) {
            dfs(marked, r + n[0], c + n[1]);
        }

        // 不用清除，避免重复走进去
    }


    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            // digitSumOne[i] 中的值就是 i 的数位之和
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }

}
