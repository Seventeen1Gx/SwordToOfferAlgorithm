public class TenPointOne {
    // 求斐波那契数列的第 n 项，n <= 39。

    public int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    // 只用缓存前两项
    public int Fibonacci_plus(int n) {
        if (n<=1)
            return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    // 由于 n <= 40 所以我们可以一次性求出所有斐波那契数列项，然后再以时间复杂度 O(1) 找到第 n 项
}
