public class FortyNine {
    // 丑数

    // 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
    //    // 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
    //    // 习惯上我们把 1 当做是第一个丑数。
    //    // 求按从小到大的顺序的第 N 个丑数。


    // 丑数肯定是在以下三个序列中选，但我们要做的是从小到大选出来！

    // 丑数数组：1
    // 2 的次方：2 4 6 ...
    // 3 的次方：3 6 9 ...
    // 5 的次方：5 10 15 ...
    //
    // 取三个序列头的最小值
    // 得到，丑数数组：1 2
    // 于是三个序列变为
    // 2 的次方：4 6 8 ...
    // 3 的次方：3 6 9 ...
    // 5 的次方：5 10 15 ...
    //
    // 取三个序列头的最小值
    // 得到，丑数数组：1 2 3
    // 于是三个序列变为
    // 2 的次方：4 6 8 ...
    // 3 的次方：6 9 12 ...
    // 5 的次方：5 10 15 ...

    // 依次类推
    // 即每次选择了哪一个序列，哪一个序列的指针就后移
    // 而下一次循环，对应 dp[ix] 就是刚才选的数
    // 最终实现效果就是维护三个指针即可
    public int getUglyNumber(int N) {
        if (N <= 6)
            return N;

        int i2 = 0, i3 = 0, i5 = 0;

        // dp[i-1] 表示第 i 个丑数
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            // 下面其实就是动一下对应列的游标，指向上面求得这个 dp[i]
            if (dp[i] == next2)
                i2++;
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
        }
        return dp[N - 1];
    }
}