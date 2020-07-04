import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sixty {
    // n 个骰子的点数

    // 把 n 个骰子扔在地上，求点数和为 s 的概率。

    // 动态规划
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        // dp[i][j] 表示前 i 个骰子产生点数 j 的次数
        long[][] dp = new long[n + 1][pointNum + 1];

        // 初始化
        // 第一个骰子产生各点数的次数
        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            // 使用 i 个骰子的最小值是 i
            for (int j = i; j <= pointNum; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    // 前 i - 1 个骰子获得 j - k，然后第 i 个骰子获得 k
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i<= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i]/totalNum));

        return ret;
    }

    // 节省空间
    // 因为求 dp[i][j] 的时候，只看 dp[i-1] 这一行
    // 所以我们用两行数组即可解决
    public List<Map.Entry<Integer, Double>> dicesSum_plus(int n) {
        // 一下根据 0 行求 1 行，一下根据 1 行求 0 行
        // 类似翻转
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[2][pointNum + 1];

        for (int i = 1; i <= face; i++) {
            dp[0][i] = 1;
        }

        // 翻转标记，标记着 0 求 1，还是 1 求 0
        int flag = 1;
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            // 清零
            for (int j = 0; j <= pointNum; j++) {
                dp[flag][j] = 0;
            }

            for (int j = i; j <= pointNum; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[flag][j] += dp[1 - flag][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i<= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i]/totalNum));

        return ret;
    }
}
