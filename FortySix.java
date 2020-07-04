public class FortySix {
    // 把数字翻译成字符串

    // 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
    // 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
    // 实现一个函数，用来计算一个数字有多少种不同的翻译方法。

    // 注意数字中可能会有 0

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        // dp[i] 表示 s[0:i) 可以解码出字符串的个数
        // dp[i] 可由 dp[i-1] 再将 s[i-1] 翻译成一个字符
        // 也可由 dp[i-2] 再将 s[i-2:i-1] 翻译成一个字符
        int[] dp = new int[n + 1];

        // 初始值
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        // 迭代求之后的
        for (int i = 0; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0)
                dp[i] += dp[i - 1];

            if (s.charAt(i-2) == '0')
                continue;

            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two < 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
