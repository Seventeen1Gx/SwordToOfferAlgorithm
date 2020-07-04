import java.util.Arrays;
import java.util.Map;

public class TenPointFour {
    // 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    // f(n) = f(n-1) + f(n-2) + ... + f(1) + f(0)
    // f(0) = 1
    // f(1) = f(0) = 1
    // f(2) = f(1) + f(0) = 2
    // f(3) = f(2) + f(1) + f(0) = 4
    // ...

    public int jumpFloorII_1(int target) {
        int[] dp = new int[target];
        // f(0) 已经加到每一项上了
        // dp[target-1] 就是 f(target)
        Arrays.fill(dp, 1);
        // 每一项都是前面各项之和
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    // 由上述
    // f(n) = f(n-1) + f(n-2) + ... + f(1) + f(0)
    // f(n-1) = f(n-2) + f(n-3) + ... + f(1) + f(0)
    // 两式相减
    // f(n) - f(n-1) = f(n-1)
    // 即 f(n) = 2*f(n-1)
    // 等比数列
    public int jumpFloorII_2(int target) {
        return (int) Math.pow(2, target - 1);
    }
}