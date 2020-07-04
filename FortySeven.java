public class FortySeven {
    // 礼物的最大价值

    // 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
    // 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。

    // 使用动态规划
    // 走到 matrix[i][j] 处的最小价值，即
    // 先走到 matrix[i-1][j]，再向下走一步
    // 或者先走到 matrix[i][j-1]，再向右走一步
    // 取上述两者的更大值即可

    // 由于每个位置 [i][j] 只取决于前一个位置和上一个位置的子问题，所以节省空间，只用一维数组进行迭代即可
    public int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0)
            return 0;

        // 列数
        int n = values[0].length;

        int[] dp = new int[n];
        //遍历行
        for (int[] value : values) {
            // 第一个位置，只取决于上一个位置
            dp[0] += value[0];
            // 遍历列
            for (int i = 0; i < n; i++) {
                // 原先的 dp[i] 就是上一个位置的最大礼物价值
                // dp[i-1] 就是前一个位置的最大礼物价值
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
        }
        return dp[n - 1];
    }
}
