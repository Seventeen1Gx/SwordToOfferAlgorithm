public class Sixteen {
    // 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。

    // 思路：分而治之
    public double Power(double base, int exponent) {
        // 特殊情况
        if (exponent == 0)
            return 1;

        // 递归出口
        if (exponent == 1)
            return base;

        // 注意负次方
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        // n 个 x 相乘，可以看成 n/2 个 x*x 相乘 → 变成递归子问题
        double pow = Power(base * base, exponent / 2);
        // 奇数幂要多乘一个 base
        if (exponent % 2 != 0)
            pow = pow * base;

        return isNegative ? 1 / pow : pow;
    }
}
