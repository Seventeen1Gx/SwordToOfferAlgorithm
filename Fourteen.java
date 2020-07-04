public class Fourteen {
    // 把一根绳子剪成多段，并且使得每段的长度乘积最大。

    // 思路：贪心
    // 尽可能多分长度为 3 的绳子，且不允许出现长度为 1 的绳子
    // 如果出现了，结合一个长度为 3 的绳子，变成两个长度为 2 的绳子
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        // n 可以分到多少个长度为 3 的绳子
        int timesOf3 = n / 3;
        // 剩余要么是 0，要么是 1，要么是 2
        if (n - timesOf3 * 3 == 1)
            // 一根长度为 3 的绳子和长度为 1 的绳子结合
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }


    // 动态规划
    public int integerBreak_plus(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // 对于 dp[i]，即长度为 i 的绳子进行分割
        // 可以长度 j 整体作为一段，剩下 (i-j) 再作为一段
        // 也可以先将 j 长度按 dp[j] 分割，剩下 (i-j) 再作为一段

        // 求 dp[i]
        for (int i = 2; i <= n; i++) {
            // 试验所有 j 可能
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
}
