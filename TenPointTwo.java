public class TenPointTwo {
    // 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？

    // 动态规划问题
    // 当 n = 1 时，只有一种覆盖方法，即 f(1) = 1
    // 当 n = 2 时，有两种覆盖方法，即 f(2) = 2
    // 当 n = 3 时，我们可以横铺一块 2*1 的砖，剩下 2*2 的区域即 f(2)，或者竖铺两块 2*1 的砖，剩下 2*1 的砖即 f(1)
    // ...
    // 当 n > 2 时，可以先横铺 2*1 的矩形，剩下 2*(n-1) 的区域即 f(n-1)，或者竖铺两块 2*1 的砖，剩下 2*(n-2) 的砖即 f(n-2)
    // 即 f(n) = f(n-1) + f(n-2)
    public int rectCover(int n) {
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
