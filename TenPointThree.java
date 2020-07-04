public class TenPointThree {
    // 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
    // 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    // 思路：n 级台阶，青蛙可以先跳 1 级，变成 f(n-1)，也可 先跳两级，变成 f(n-2)。
    // n = 1 时，f(1) = 1，n = 2 时，f(2) = 2 。

    public int jumpFloor(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
